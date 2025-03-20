package io.cheonkyu;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

// 스프링이 이 클래스의 인스턴스를 생성하고 스프링 컨텍스트에 추가
@Component
public class Car {
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // 빈이 생성된 이후에 수행할 메소드
  @PostConstruct
  public void init() {
    this.name = "스프링-자동차";
  }
}
