package com.company;

import java.util.Random;

public class Car {
    private String id;
    private State state;
    private Record record;

    public Car(String id) {
        this.id = id;
        state = State.ROAD;
    }

    public void changeState(Parking p,int time, int day){
        if(new Random().nextInt(100)+1 <= 3){
            switch (state){
                case ROAD:
                    if(p.getCars().size() < 20){
                        System.out.println("car on park");
                        state = State.PARKING;
                        record = new Record(this,time,day);
                        p.getCars().add(this);
                    }else {
                        System.out.println("no empty parking lots");
                    }
                    break;
                case PARKING:
                    System.out.println("car out park");
                    state = State.ROAD;
                    record.setTimeOut(time);
                    record.setDayOut(day);
                    p.getJournal().add(record);
                    p.getCars().remove(this);
                    break;
            }
        }
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return id;
    }
}
