package guitar_order_system;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestockThresholdTest {

    @Test
    public void calculatesRestockThreshold() {
        AverageDailySales dailySales = (product) -> 2;
        Product stratocaster = new Product(757, 4, 10, 0, dailySales);

        assertEquals(20, stratocaster.restockThreshold());
    }

    @Test
    public void calculatesRestockThresholdWithOutstandingOrders() {
        AverageDailySales dailySales = (product) -> 2;
        Product stratocaster = new Product(757, 4, 10, 5, dailySales);

        assertEquals(15, stratocaster.restockThreshold());
    }
}
