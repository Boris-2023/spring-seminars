package ru.gb.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.gb.interfaces.iEngine;

@Component
@Primary
//@Lazy
public class DieselEngine implements iEngine {
    public DieselEngine() {
        System.out.println("Diesel Engine created!");
    }

    @Override
    public void startEngine() {
        System.out.println("Diesel says RRRRRR!");
    }

    @Override
    public String toString() {
        return "Diesel Engine";
    }
}
