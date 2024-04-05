package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.ProjectConfig;
import ru.gb.domain.Car;

public class Main {
    public static void main(String[] args) {

        // ---> using Java core
        Car myCar = new Car();
        myCar.setModel("X1");
        myCar.setMadeBy("BMW");
        System.out.println(myCar);

        // ----> using pure Spring
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // -> gets access to Cars from IoC
        // Primary choice - by-default
        Car simpleCar1 = context.getBean(Car.class);
        System.out.println(simpleCar1);

        // by name ".."
        Car simpleCar2 = context.getBean("BMW", Car.class);
        System.out.println(simpleCar2);

        // by name = ".."
        Car simpleCar3 = context.getBean("AUDI", Car.class);
        System.out.println(simpleCar3);


        // gets access to String from IoC
        String str = context.getBean(String.class);
        System.out.println(str);

        // gets access to Integer from IoC
        Integer value = context.getBean(Integer.class);
        System.out.println(value);

        // checking @Scope: BMW - singleton, AUDI - prototype
        Car c1 = context.getBean("BMW", Car.class);
        Car c2 = context.getBean("BMW", Car.class);
        Car c3 = context.getBean("AUDI", Car.class);
        Car c4 = context.getBean("AUDI", Car.class);

        System.out.println();
        System.out.println("BMW (singleton):\t" + c1 + " vs " + c2);
        System.out.println("AUDI (prototype):\t" + c3 + " vs " + c4);


    }
}