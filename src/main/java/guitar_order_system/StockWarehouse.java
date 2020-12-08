package guitar_order_system;

import com.google.gson.Gson;

public class StockWarehouse implements Warehouse{
    private DataSource dataSource;

    public StockWarehouse(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Stock productById(int productId) {
        String json = dataSource.fetchJson("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product?id=" + productId);
        Product targetObject = new Gson().fromJson(json, Product.class);
        return targetObject;
    }
}
