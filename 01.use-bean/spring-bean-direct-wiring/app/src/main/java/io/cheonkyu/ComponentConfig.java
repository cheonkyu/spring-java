package io.cheonkyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 1. 스프링 구성 클래스로 정의
@Configuration
public class ComponentConfig {
  // 2. 빈 등록
  @Bean
  @Primary // 기본 빈으로 등록
  public Car car() {
    Car car = new Car();
    car.setName("자동차1호");
    return car;
  }

  @Bean
  public Person person() {
    Person p = new Person();
    p.setName("cheonkyu");
    p.setCar(car());
    return p;
  }
}
