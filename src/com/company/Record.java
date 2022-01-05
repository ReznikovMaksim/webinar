package com.company;

public class Record {
    private Car car;
    private int dayIn;
    private int dayOut;
    private int timeIn;
    private int timeOut;

    public Record(Car car, int timeIn, int dayIn) {
        this.car = car;
        this.dayIn = dayIn;
        this.timeIn = timeIn;
    }

    public int timeInMinusTimeOut(){
        return timeOut - timeIn;
    }

    public void setDayOut(int dayOut) {
        this.dayOut = dayOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public Car getCar() {
        return car;
    }

    public int getDayIn() {
        return dayIn;
    }

    public int getDayOut() {
        return dayOut;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }
}
