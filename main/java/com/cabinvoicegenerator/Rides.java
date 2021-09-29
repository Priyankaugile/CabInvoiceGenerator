package com.cabinvoicegenerator;

public class Rides {
    public double distance;
    public int time;
    public PrimiumRides rides;

    public Rides(double distance, int time, PrimiumRides rides) {
        this.distance = distance;
        this.time = time;
        this.rides=rides;
    }
}
