import com.cabinvoicegenerator.CabInvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double TotalFare = cabInvoiceGenerator.CalculateFare(5.0, 4);
        Assertions.assertEquals(54, TotalFare);
    }

    @Test
    void givenDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double TotalFare = cabInvoiceGenerator.CalculateFare(0.1, 2);
        Assertions.assertEquals(5, TotalFare);
    }
}
