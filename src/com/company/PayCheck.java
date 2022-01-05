package com.company;

public class PayCheck {
    private Car car;
    private double price;
    private int day;

    public PayCheck(Car car, double price, int day) {
        this.car = car;
        this.price = price;
        this.day = day;
    }

    public Car getCar() {
        return car;
    }

    public double getPrice() {
        return price;
    }

    public int getDay() {
        return day;
    }
}
