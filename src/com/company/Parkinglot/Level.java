package com.company.Parkinglot;

import com.company.Parkinglot.Vehicle.ParkingSpot;
import com.company.Parkinglot.Vehicle.Vehicle;
import com.company.Parkinglot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private List<ParkingSpot> spots;

    Level(int numOfSpots, int numOfCompact, int numOfLarge){
        List<ParkingSpot> list=new ArrayList<>(numOfSpots);
        int i=0;
        for (; i < numOfCompact; i++) {
            list.add(new ParkingSpot(VehicleType.compact));
        }
        int j=0;
        for(; j < numOfLarge;j++){
            list.add(new ParkingSpot(VehicleType.large));
        }
        spots = Collections.unmodifiableList(list);
    }
    public boolean park(Vehicle v){
        for (ParkingSpot s:spots) {
            if(s.fit(v)){
                s.park(v);
                System.out.println("park successfully");
                return true;
            }
        }
        return false;
    }
    public boolean hasSpot(Vehicle v){
        for (ParkingSpot s:spots) {
            if(s.fit(v)){
                System.out.println("find Spot");
                return true;
            }
        }
        System.out.println("can't find Spot");
        return false;
    }

    public boolean leave(Vehicle v){
        for(ParkingSpot s:spots){
            if(s.getVehicle()==v){
                s.leave();
                return true;
            }
        }
        return false;
    }
}
