package io.cheonkyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

// 1. 스프링이 이 스프링 구성 클래스로 정의
@Configuration
@ComponentScan(basePackages = "io.cheonkyu") // 스프링에게 스테레오타입 어노테이션이 지정된 클래스의 위치를 알려줌
public class ComponentConfig {
}
