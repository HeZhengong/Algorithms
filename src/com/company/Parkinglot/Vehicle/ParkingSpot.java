package com.company.Parkinglot.Vehicle;

public class ParkingSpot {
    private final VehicleType size;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleType size){
        this.size=size;
    }
    public boolean fit(Vehicle v){
        return currentVehicle==null&&size.getSize()>=v.getSize().getSize();
    }
    public void park(Vehicle v){
        currentVehicle=v;
    }
    public void leave(){
        currentVehicle=null;
    }

    public Vehicle getVehicle(){
        return currentVehicle;
    }
}
