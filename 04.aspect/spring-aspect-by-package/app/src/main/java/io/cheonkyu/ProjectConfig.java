package io.cheonkyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "io.cheonkyu" })
public class ProjectConfig {
  // @Aspect 어노테이션은 스테레오타입 어노테이션이 아니라 빈으로 등록해줘야함
  @Bean
  public LoggingAspect aspect() {
    return new LoggingAspect();
  }
}
