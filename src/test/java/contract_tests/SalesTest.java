package contract_tests;

import guitar_order_system.BaseSalesTest;
import guitar_order_system.SalesData;
import guitar_order_system.Web;

public class SalesTest extends BaseSalesTest {

    @Override
    protected SalesData createSalesData() {
        return new SalesData(new Web());
    }
}
