package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.ProjectConfig;
import ru.gb.domain.Car;
import ru.gb.domain.Engine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car car = context.getBean(Car.class);
        System.out.println(car);

        Engine engine = context.getBean(Engine.class);
        System.out.println(engine);

    }

}