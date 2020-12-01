package guitar_order_system;

public class RestockItem {
    private Stock product;
    private int restockAmount;

    public RestockItem(Stock product, int restockAmount) {
        this.product = product;
        this.restockAmount = restockAmount;
    }

    public Stock getProduct() {
        return product;
    }

    public int getRestockAmount() {
        return restockAmount;
    }
}
