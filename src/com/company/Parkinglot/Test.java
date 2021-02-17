package com.company.Parkinglot;

import com.company.Parkinglot.Vehicle.Car;
import com.company.Parkinglot.Vehicle.ParkingSpot;
import com.company.Parkinglot.Vehicle.Truck;
import com.company.Parkinglot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ParkingLot p=new ParkingLot(4,10, 7,3);
        List<Vehicle> list=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v=i%2==0? new Car() : new Truck();
            list.add(v);
            boolean hasSpot = p.hasSpot(v);
            if(i<40){
                assert hasSpot;
                assert p.park(v);
            }
            else{
                assert !hasSpot;
                assert !p.park(v);
            }
        }
        assert list.size()==50;
        int i=0;
        for(Vehicle v:list){
            assert i>=40||p.leave(v);
            i++;
        }
    }
}
