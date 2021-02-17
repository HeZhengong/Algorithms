package com.company.Parkinglot.Vehicle;

public enum VehicleType {
    compact(1),
    large(2);

    private int size;
    VehicleType(int size){
        this.size=size;
    }
    public int getSize(){
        return size;
    }
}
