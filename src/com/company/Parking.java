package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> cars;
    private List<Record> journal;

    public Parking() {
        cars = new ArrayList<>();
        journal = new ArrayList<>();
    }

    public List<PayCheck> getPayChecks(){
        List<PayCheck> checks = new ArrayList<>();
        for(int i = 0; i < journal.size(); i++){
            double price = 0;
            int time = 0;
            Record r = journal.get(i);
            if(r.getTimeOut() - r.getTimeIn() >= 30 || r.getTimeIn() > 720 && r.getTimeOut() >= 30){
                if(r.getTimeIn() < 720 && r.getTimeOut() < 720){
                    time = r.getTimeOut() - r.getTimeIn();
                }else if(r.getTimeIn() < 720 && r.getTimeOut() > 720){
                    time = 720 - r.getTimeIn();
                }else if(r.getTimeIn() > 720 && r.getTimeOut() < 720){
                    time = r.getTimeOut();
                }
            }
            if(time != 0){
                price = time / 5.0 * 10;
                checks.add(new PayCheck(r.getCar(),price,r.getDayOut()));
            }
        }
        return checks;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Record> getJournal() {
        return journal;
    }
}
