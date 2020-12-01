package guitar_order_system;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockWarehouseTest extends BaseStockWarehouseTest {

    @Override
    protected DataSource createDataSource() {
        return new DataSource() {
                @Override
                public String fetchJson(String urlString) {
                    return "{\"id\":811,\"make\":\"Epiphone\",\"range\":\"Les Paul\",\"model\":\"Les Paul Classic\",\"description\":\"Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst\",\"price\":399,\"stock\":53,\"rackspace\":30,\"leadTime\":14,\"minOrder\":20}";
                }
            };
    }
}
