package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import ru.gb.domain.Car;

@Configuration
public class ProjectConfig {

    @Bean("BMW")
    @Scope("singleton")
    Car car1() {
        Car car = new Car();
        car.setModel("X1");
        car.setMadeBy("BMW");
        return car;
    }

    @Bean
    @Primary
    Car car2() {
        Car car = new Car();
        car.setModel("H7");
        car.setMadeBy("HAVAL");
        return car;
    }

    @Bean(name = "AUDI")
    @Scope("prototype")
    Car car3() {
        Car car = new Car();
        car.setModel("A3");
        car.setMadeBy("AUDI");
        return car;
    }


    @Bean
    String hello() {
        return "Hello!";
    }

    @Bean
    Integer ten() {
        return 10;
    }

}
