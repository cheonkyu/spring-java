# ASPECT

1. 구성 클래스에 @EnableAspectJAutoProxy 어노테이션을 추가, 스프링 앱에서 애스펙트 매커니즘 활성화
2. 새 클래스를 생성하고 @Aspect 어노테이션을 추가. @Bean 혹은 스테레오타입 어노테이션(@Component 등)을 사용하여 스프링 컨텍스트에 빈을 추가
3. 애스펙트 로직을 구현할 메소드 정의, 스프링에 어드바이스 애너테이션을 사용해서 언제 어떤 메소드를 가로챌 것인지 지시
4. 애스펙트 로직 구현

## Aspect

- 패키지 명 + 메소드 명 정의 방식
- 커스텀 어노테이션 방식

## Aspect 실행 체인

spring-aspect-chaining 참고

`@Order`를 이용해 여러 Aspect 간에 순서를 보장해줌

## AOP 패키지 이슈

Aspect와 대상 패키지가 같이 있을때 에러 발생

```
경고: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'aspect' defined in io.cheonkyu.ProjectConfig: Failed to instantiate [io.cheonkyu.LoggingAspect]: Factory method 'aspect' threw exception with message: Error creating bean with name 'aspect': Requested bean is currently in creation: Is there an unresolvable circular reference or an asynchronous initialization dependency?
```
