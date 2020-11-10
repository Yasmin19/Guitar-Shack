package guitar_order_system;

public class SalesUnitTest extends BaseSalesTest {
    @Override
    protected SalesData createSalesData() {
        return new SalesData(urlString -> "{\"productID\":811,\"startDate\":\"7/17/2019\",\"endDate\":\"7/27/2019\",\"total\":31}");
    }
}
