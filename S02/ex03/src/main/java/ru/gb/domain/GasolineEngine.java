package ru.gb.domain;

import org.springframework.stereotype.Component;
import ru.gb.interfaces.iEngine;

@Component
//@Primary
//@Lazy
public class GasolineEngine implements iEngine {
    public GasolineEngine() {
        System.out.println("Diesel Engine created!");
    }

    @Override
    public void startEngine() {
        System.out.println("Gasoline says rrrrrrr!");
    }

    @Override
    public String toString() {
        return "Gasoline Engine";
    }
}
