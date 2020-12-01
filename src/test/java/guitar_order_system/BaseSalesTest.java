package guitar_order_system;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public abstract class BaseSalesTest {
    @Test
    public void getTotalSales() {
        Sales sales = createSalesData();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 6, 17);
        Date startDate = calendar.getTime();
        calendar.set(2019, 6, 27);
        Date endDate = calendar.getTime();
        Integer totalSales = sales.total(811, startDate, endDate);
        assertThat(totalSales, greaterThan(0));
    }

    protected abstract SalesData createSalesData();
}
