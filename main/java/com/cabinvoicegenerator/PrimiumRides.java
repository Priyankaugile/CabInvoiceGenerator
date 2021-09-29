package com.cabinvoicegenerator;

public class PrimiumRides {

    public static PrimiumRides Normal;
    private final double costperkm;
    private final double costpermin;

    PrimiumRides(double costperkm, double costpermin, double minfare){
        this.costperkm=costperkm;
        this.costpermin=costpermin;
    }

    public double calcCostOfCabRide(Rides ride) {
        return ride.distance * costperkm + ride.time * costpermin;
    }
}
