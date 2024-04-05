package ru.gb.domain;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String type = "Gasoline";

    public Engine() {
        System.out.println("New engine created!");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engine {" +
                "type='" + type + '\'' +
                '}';
    }

}
