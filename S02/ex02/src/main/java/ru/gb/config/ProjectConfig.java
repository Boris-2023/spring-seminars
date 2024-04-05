package ru.gb.config;

import org.springframework.context.annotation.*;
import ru.gb.domain.Car;
import ru.gb.domain.Engine;

@Configuration
@ComponentScan(basePackages = "ru.gb.domain")
public class ProjectConfig {

//    @Bean("BMW")
//    Car car1() {
//        Car car = new Car(engine1());
//        car.setModel("X1");
//        car.setMadeBy("BMW");
//        return car;
//    }
//
//    @Bean("Gasoline")
//    Engine engine1(){
//        Engine engine = new Engine();
//        engine.setType("Gasoline");
//        return engine;
//    }

}
