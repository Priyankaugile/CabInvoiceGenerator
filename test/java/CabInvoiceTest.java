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
        Assertions.assertEquals(54, TotalFare);
    }

    @Test
    void givenDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double TotalFare = cabInvoiceGenerator.calculateFare(0.1, 2);
        Assertions.assertEquals(5, TotalFare);
    }

    @Test
    void givenMultipleRides_ShouldCalculateAggregateTotal() {

        Rides[] rides = {new Rides(1.0, 5,PrimiumRides.Normal),
                new Rides(0.2, 2, PrimiumRides.Normal)};

        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(20, totalFare, 0.0);
    }
}
