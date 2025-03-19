package io.cheonkyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ComponentConfig.class);

        // primary로 등록된 빈
        Car c = context.getBean(Car.class);
        System.out.println(c.getName());

        // 빈 이름을 명시해줌
        Car testCar = context.getBean("testcar", Car.class);
        System.out.println(testCar.getName());

        // 클래스 타입으로 스프링 컨텍스트에서 빈을 가져온다
        String s = context.getBean(String.class);
        System.out.println(s);
        Integer i = context.getBean(Integer.class);
        System.out.println(i);
    }

}
