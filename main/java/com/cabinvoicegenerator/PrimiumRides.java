package com.cabinvoicegenerator;

public class PrimiumRides {

    public static final PrimiumRides PREMIUM = null;
    public static PrimiumRides Normal;

    private final double costperkm;
    private final double costpermin;
    private final double minfare;

    PrimiumRides(double costperkm, double costpermin, double minfare){
        this.costperkm=costperkm;
        this.costpermin=costpermin;
        this.minfare=minfare;
    }

    public double calcCostOfCabRide(Rides ride) {
        double rideCost = ride.distance * costperkm + ride.time * costpermin;
        return rideCost;
    }
}
