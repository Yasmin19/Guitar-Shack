package contract_tests;

import guitar_order_system.BaseStockWarehouseTest;
import guitar_order_system.DataSource;
import guitar_order_system.Web;

public class StockWarehouseContractTest extends BaseStockWarehouseTest {
    @Override
    protected DataSource createDataSource() {
        return new Web();
    }
}
