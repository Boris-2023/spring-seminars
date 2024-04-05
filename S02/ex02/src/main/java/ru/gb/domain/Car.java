package ru.gb.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "X1";
    private String madeBy = "BMW";
    @Autowired
    private Engine carEngine;

//    public Car(Engine carEngine) {
//        this.carEngine = carEngine;
//        System.out.println("New car created!");
//    }

     public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    @Override
    public String toString() {
        return "Car {" +
                "model = '" + model + '\'' +
                ", madeBy = '" + madeBy + '\'' +
                ", carEngine = " + carEngine +
                '}';
    }
}
