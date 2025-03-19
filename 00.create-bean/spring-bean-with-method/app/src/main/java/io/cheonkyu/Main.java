package io.cheonkyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ComponentConfig.class);

        Car c = new Car();
        c.setName("스프링-자동차");
        
        // 인스턴스를 반환할 서플라이어를 정의
        Supplier<Car> carSupplier = () -> c;

        // 컨텍스트에 빈을 등록해줌
        context.registerBean("car1", Car.class, carSupplier);

        Car beanCar = context.getBean(Car.class);
        System.out.println(beanCar.getName());
    }

}
