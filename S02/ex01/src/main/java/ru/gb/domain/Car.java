package ru.gb.domain;

public class Car {
    private String model;
    private String madeBy;

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

//    @Override
//    public String toString() {
//        return "Car {" +
//                "model = '" + model + '\'' +
//                ", madeBy = '" + madeBy + '\'' +
//                '}';
//    }
}
