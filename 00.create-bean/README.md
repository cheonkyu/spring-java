# spring-bean

스프링 컨텍스트에 객체 인스턴스(빈)을 추가하는 것

스프링 컨텍스트는 스프링이 관리하기 원하는 인스턴스를 담을 바구니라고 할 수 있음

## 스프링 컨텍스트에 빈을 추가하는 방법은 세가지

1. @Bean 어노테이션
2. 스테레오타입 어노테이션
3. 프로그래밍 방식

실무에서는 `스테레오타입 어노테이션`을 사용 후, 다른 방법으로 빈을 추가할 수 없을 때 @Bean을 사용
