package io.cheonkyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ComponentConfig.class);

        // primary로 등록된 빈
        Car c = context.getBean(Car.class);
        System.out.println(c.getName());

        Person p = context.getBean(Person.class);
        System.out.println(p.getName());
        System.out.println(p.getCar().getName());
    }

}
