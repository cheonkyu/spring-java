package io.cheonkyu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @GetMapping("/echo")
  public ResponseEntity<?> getEcho() {
    CustomLogger.logInfo(getClass(), "test");
    return ResponseEntity.ok("echo");
  }
}
