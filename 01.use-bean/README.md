# 빈 사용하기

빈들 간에 관계 설정 방법 `@Autowired`

- 필드 주입
- 생성자 주입
- 세터 주입

동일한 타입의 빈이 있을때
빈 이름을 지정(`@Bean("빈이름")`) 후 `@Qualifier` 어노테이션을 사용해서 빈 이름 주입

- @Bean 으로 bean을 생성하게 되면, method name이 bean name으로 생성된다.
- 같은 Type의 bean이 1개만 있다면, bean name과 관련없이 bean을 주입해준다.
- 같은 Type의 bean이 여러 개 있으면, @Qualifier가 없어도 bean name과 field name을 매칭해서 bean을 주입해준다.
- (!) @Primary가 있으면, bean name을 무시하고 Type 기반으로 Primary인 Bean을 주입한다.
- @Qualifier가 있으면, 무조건 bean name 기준으로 주입해준다. (없으면 오류가 발생한다)
- @Qualifier 어노테이션이 @Primary 어노테이션보다 우선하여 적용된다.

https://tech.kakaopay.com/post/martin-dev-honey-tip-2/
