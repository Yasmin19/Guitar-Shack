package guitar_order_system;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public abstract class BaseSalesTest {
    @Test
    public void getTotalSales() {
        Sales sales = createSalesData();
        Integer totalSales = sales.total(811, new Date(2019, 6, 17), new Date(2019, 6, 27));
        assertThat(totalSales, greaterThan(0));
    }

    protected abstract SalesData createSalesData();
}
