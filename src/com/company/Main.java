package com.company;

import javax.swing.text.Caret;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        getCars(cars);
        Parking parking = new Parking();
        int days = 1;
        while (days <= 30){
            for(int i = 0; i <= 1440; i+=5){
                int currentTime = i;
                int currentDay = days;
                cars.forEach(c -> c.changeState(parking,currentTime,currentDay));
            }
            days++;
        }
        List<PayCheck> payChecks = parking.getPayChecks();
        var payForOneDay = payChecks.stream()
                .collect(groupingBy(PayCheck::getDay,summingDouble(PayCheck::getPrice)));
        var min = payChecks.stream()
                .min(Comparator.comparingDouble(PayCheck::getPrice))
                .map(PayCheck::getPrice).get();
        var max = payChecks.stream()
                .max(Comparator.comparingDouble(PayCheck::getPrice))
                .map(PayCheck::getPrice).get();
        var average = payChecks.stream()
                .mapToDouble(PayCheck::getPrice)
                .sum() / payChecks.size();
        var longest = parking.getJournal().stream()
                .sorted(Comparator.comparingDouble(Record::timeInMinusTimeOut).reversed())
                .limit(10)
                .collect(Collectors.toList());
        var count = parking.getJournal().stream()
                .filter(r -> r.timeInMinusTimeOut() < 30)
                .collect(groupingBy(Record::getDayOut,counting()));
    }

    private static void getCars(List<Car> cars){
        for (int i = 0; i < 200; i++){
            cars.add(new Car("00" + i));
        }
    }
}
