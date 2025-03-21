package io.cheonkyu.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManager {
  public static <T> T read(String path) {
    try {
      File file = new File(path);
      ObjectMapper objectMapper = new ObjectMapper();
      T result = objectMapper.readValue(file, new TypeReference<T>() {
      });
      System.out.println(result.getClass());
      return result;
    } catch (IOException ioe) {
      System.out.println("ESRESRS");
      System.out.println(ioe);
      return null;
    }
  }

  public static <T> Boolean write(T data, String path) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();

      File file = new File(path);
      file.getParentFile().mkdirs(); // 파일 생성하려는 경로에 디렉터리가 없을 때 생성

      objectMapper.writeValue(file, data);
      return true;
    } catch (IOException ioe) {
      System.out.println(ioe);
      return false;
    }
  }
}
