package com.company.Parkinglot;

import com.company.Parkinglot.Vehicle.Vehicle;

public class ParkingLot {
    private final Level[] levels;


    public ParkingLot(int numOfLevels, int numSpotsPerLevel, int numSpotsOfCompact, int numSpotsOfLarge) {
        levels=new Level[numOfLevels];

        for (int i = 0; i < numOfLevels; i++) {
            levels[i]=new Level(numSpotsPerLevel,numSpotsOfCompact,numSpotsOfLarge);
        }
    }

    public boolean hasSpot(Vehicle v){
        for (Level l: levels) {
            if(l.hasSpot(v)){
                System.out.println("find Spot");
                return true;
            }
        }
        System.out.println("can't find Spot");
        return false;
    }

    public boolean park(Vehicle v){
        for(Level l:levels){
            if(l.park(v)){
                System.out.println("park successfully");
                return true;
            }
        }
        System.out.println("sorry");
        return false;
    }

    public boolean leave(Vehicle v){
        for(Level l:levels){
            if(l.leave(v)){
                return true;
            }
        }
        return false;
    }
}
