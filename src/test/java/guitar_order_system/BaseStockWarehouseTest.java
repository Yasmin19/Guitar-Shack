package guitar_order_system;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BaseStockWarehouseTest {
    @Test
    public void fetchProductById() {
        DataSource dataSource = createDataSource();
        StockWarehouse stockWarehouse = new StockWarehouse(dataSource);
        assertEquals(811, ((Product) stockWarehouse.productById(811)).getId());
    }

    protected abstract DataSource createDataSource();
}
