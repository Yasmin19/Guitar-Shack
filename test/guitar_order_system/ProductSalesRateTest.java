package guitar_order_system;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductSalesRateTest {

    @Test
    public void atLeastOneSaleInLastMonth() {
        Sales sales = new Sales() {
            @Override
            public int total(int productID, Date startDate, Date endDate) {
                return 10;
            }
        };
        Date todaysDate = new Date(2020,9,20);
        AverageDailySales averageDailySales = new ProductSalesRate(sales,  new DateRange(todaysDate));
        assertEquals(0.33, averageDailySales.getAverageSales(new Product(811, 10,10,10, averageDailySales)),0.01);
    }

    @Test
    public void correctStartAndEndDatesForAtLeastOneSaleInLastMonth() {
        Sales sales = mock(Sales.class);
        Date todaysDate = new Date(2020,9,20);
        AverageDailySales averageDailySales = new ProductSalesRate(sales,  new DateRange(todaysDate));

        averageDailySales.getAverageSales(new Product(811, 10, 10, 10, averageDailySales));
        verify(sales).total(811, new Date(2020,8,20), new Date(2020, 9, 20));
    }

    @Test
    public void correctStartAndEndDatesForHistoricSales() {
        Sales sales = mock(Sales.class);
        when(sales.total(anyInt(), any(), any())).thenAnswer(new Answer() {
            int count = 0;

            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                if (count == 0) {
                    count++;
                    return 0;
                }
                return 25;
            }
        });
        Date todaysDate = new Date(2020,9,20);
        AverageDailySales averageDailySales = new ProductSalesRate(sales, new DateRange(todaysDate));

        averageDailySales.getAverageSales(new Product(811,10,10,10, averageDailySales));
        verify(sales, atLeastOnce()).total(811, new Date(2019,8,20), new Date(2019,9,20));
    }
}
