package io.cheonkyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cheonkyu.dto.Customer;
import io.cheonkyu.dto.CustomerTotalCountDTO;
import io.cheonkyu.pipe.Handler;
import io.cheonkyu.pipe.Pipeline;
import io.cheonkyu.utils.FileManager;

@RestController
public class TaskController {
  @GetMapping("/task")
  public ResponseEntity<?> task() {
    // task1();
    task2();
    return null;
  }

  private static boolean task1() {
    final String INPUT_PATH = "/Users/keke/Documents/GitHub/spring-java/07.file/file-server/data/input/customer.json";
    final String OUTPUT_PATH = "/Users/keke/Documents/GitHub/spring-java/07.file/file-server/data/output/problem_1.json";
    var result = new Pipeline<>((Handler<String, List<Customer>>) input -> FileManager.<List<Customer>>read(input))
        .addHandler(rawData -> {
          return new CustomerTotalCountDTO.Output(rawData.size());
        })
        .addHandler(data -> FileManager.write(data, OUTPUT_PATH))
        .execute(INPUT_PATH);
    return result;
  }

  private static boolean task2() {
    final String INPUT_PATH = "/Users/keke/Documents/GitHub/spring-java/07.file/file-server/data/input/customer.json";
    final String OUTPUT_PATH = "/Users/keke/Documents/GitHub/spring-java/07.file/file-server/data/output/problem_2.json";
    var result = new Pipeline<>((Handler<String, List<Customer>>) input -> FileManager.<List<Customer>>read(input))
        .addHandler((List<Customer> rawData) -> rawData
            .stream()
            .filter((Customer x) -> "dormant".equals(x.status()))
            .map((Customer x) -> x.customerId())
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList()))
        .addHandler(data -> FileManager.write(data, OUTPUT_PATH))
        .execute(INPUT_PATH);
    return result;
  }
}
