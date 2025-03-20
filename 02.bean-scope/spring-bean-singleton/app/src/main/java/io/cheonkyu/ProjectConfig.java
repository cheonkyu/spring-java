package io.cheonkyu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "io.cheonkyu" })
public class ProjectConfig {
  // @Bean
  // public CommentService commentService() {
  // return new CommentService();
  // }
}
