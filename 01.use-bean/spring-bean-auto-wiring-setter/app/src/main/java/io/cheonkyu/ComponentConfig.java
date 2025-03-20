package io.cheonkyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

// 1. 스프링이 이 스프링 구성 클래스로 정의
@Configuration
@ComponentScan(basePackages = "io.cheonkyu") // 스프링에게 스테레오타입 어노테이션이 지정된 클래스의 위치를 알려줌
public class ComponentConfig {
  // 2. 빈 등록
  // @Bean
  // @Primary // 기본 빈으로 등록
  // public Car car() {
  //   Car car = new Car();
  //   car.setName("자동차1호");
  //   return car;
  // }

  // @Bean("testcar")
  // public Car testCar() {
  //   Car car = new Car();
  //   car.setName("자동차테스트1호");
  //   return car;
  // }

  // @Bean
  // String hello() {
  //   return "hello";
  // }

  // @Bean
  // Integer ten() {
  //   return 10;
  // }
}
