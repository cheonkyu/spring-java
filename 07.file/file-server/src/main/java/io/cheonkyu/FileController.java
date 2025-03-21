package io.cheonkyu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
  private static final String UPLOAD_DIR = "/Users/keke/Documents/GitHub/spring-java/07.file/file-server/data/";

  // 파일 업로드 처리
  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    if (file.isEmpty()) {
      model.addAttribute("message", "No file selected");
      return "upload";
    }

    // 파일 확장자 검사 (이미지 파일만 받기)
    String filename = file.getOriginalFilename();
    if (!isImageFile(filename)) {
      model.addAttribute("message", "Only image files are allowed.");
      return "upload";
    }

    try {
      // 파일 저장
      Path path = Paths.get(UPLOAD_DIR + filename);
      file.transferTo(path.toFile());
      model.addAttribute("message", "File uploaded successfully: " + filename);
    } catch (IOException e) {
      System.out.println(e);
      model.addAttribute("message", "Failed to upload file: " + e.getMessage());
    }
    return "upload";
  }

  // 이미지 파일인지 확인하는 메소드
  private boolean isImageFile(String filename) {
    // 이미지 파일 확장자 목록 (확장자 검사)
    String[] validExtensions = { "jpg", "jpeg", "png", "gif", "bmp", "tiff" };
    for (String ext : validExtensions) {
      if (filename.toLowerCase().endsWith(ext)) {
        return true;
      }
    }
    return false;
  }

  // 파일 다운로드
  @GetMapping("/download")
  public ResponseEntity<byte[]> downloadFile(@RequestParam("filename") String filename) throws IOException {
    Path path = Paths.get(UPLOAD_DIR + filename);
    byte[] fileContent = Files.readAllBytes(path);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=" + filename);

    return ResponseEntity.ok()
        .headers(headers)
        .body(fileContent);
  }
}
