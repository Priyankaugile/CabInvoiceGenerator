import com.cabinvoicegenerator.CabInvoiceGenerator;
import com.cabinvoicegenerator.PrimiumRides;
import com.cabinvoicegenerator.Rides;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double TotalFare = cabInvoiceGenerator.calculateFare(5.0, 4);
        Assertions.assertEquals(54, TotalFare, 0.0);
    }

    @Test
    void givenDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double TotalFare = cabInvoiceGenerator.calculateFare(0.1, 2);
        Assertions.assertEquals(5, TotalFare, 0.0);
    }

    @Test
    void givenMultipleRides_ShouldCalculateAggregateTotal() {

        Rides[] rides = {new Rides(1.0, 5, PrimiumRides.Normal),
                new Rides(0.2, 2, PrimiumRides.Normal)};

        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void ReturnTotalRidesTotalFareandAverageFareperRide() {
        Rides[] rides = {new Rides(1.0, 5, PrimiumRides.Normal),
                new Rides(0.2, 2, PrimiumRides.Normal)};

        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        int noOfRides = cabInvoiceGenerator.numberOfRides(rides);
        double averageFare = cabInvoiceGenerator.calculateAverageFarePerRide(rides);

        Assertions.assertEquals(20, totalFare, 0.0);
        Assertions.assertEquals(2, noOfRides);
        Assertions.assertEquals(10, averageFare, 0.0);
    }

    @Test
    public void givenUserIdReturnTheInvoice() {
        String userID = "Driver1";
        Rides[] rides = new Rides[]{new Rides(1.0, 5, PrimiumRides.Normal),
                new Rides(0.2, 2, PrimiumRides.Normal)
        };
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        cabInvoiceGenerator.addRides(userID, rides);
        double rideDetails = cabInvoiceGenerator.getRidesDetails(userID);
        int NoOfRides = cabInvoiceGenerator.numberOfRides(rides);
        Assertions.assertEquals(20, rideDetails, 0.0);
    }

    @Test
    void addingPremiumAndNormalRide() {
        String userID = "Driver1";
        Rides[] rides = new Rides[]{new Rides(1.0, 5, PrimiumRides.PREMIUM),
                new Rides(0.2, 2, PrimiumRides.Normal)
        };
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        cabInvoiceGenerator.addRides(userID, rides);
        double rideDetails = cabInvoiceGenerator.getRidesDetails(userID);
        int NoOfRides = cabInvoiceGenerator.numberOfRides(rides);
        Assertions.assertEquals(20, rideDetails, 0.0);
    }
}
