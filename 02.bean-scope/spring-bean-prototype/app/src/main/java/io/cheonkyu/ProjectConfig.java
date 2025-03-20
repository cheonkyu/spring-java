package io.cheonkyu;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "io.cheonkyu" })
public class ProjectConfig {
  @Bean("commentServiceTest")
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public CommentService commentService() {
    return new CommentService();
  }
}
