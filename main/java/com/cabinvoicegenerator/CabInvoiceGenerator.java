package com.cabinvoicegenerator;

public class CabInvoiceGenerator {
    RideRepository rideRepository = new RideRepository();
    private final int COST_PER_KM = 10;
    private final int COST_PER_MINUTE = 1;
    public int MIN_FARE = 5;
    double totalFare;

    public double calculateFare(double distance, int time) {

        totalFare = COST_PER_KM * distance + COST_PER_MINUTE * time;
        if(totalFare < MIN_FARE)
            totalFare = MIN_FARE;
        return totalFare;
    }

    public double calculateFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);

        return totalFare;
    }

    public int numberOfRides(Rides[] rides) {
        return rides.length;
    }

    public double calculateAverageFarePerRide(Rides[] rides) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        double numberOfRides = rides.length;
        double averageFare = totalFare/numberOfRides;
        return averageFare;
    }

    public double getRidesDetails(String userID) {
        return this.calculateFare(rideRepository.getRides(userID));
    }

    public void addRides(String userID, Rides[] rides) {
        rideRepository.addRides(userID, rides);
     }
}
