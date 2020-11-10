package guitar_order_system;

public class RestockItem {
    private int productId;
    private int restockAmount;

    public RestockItem(int productId, int restockAmount) {
        this.productId = productId;
        this.restockAmount = restockAmount;
    }

    public int getProductId() {
        return productId;
    }

    public int getRestockAmount() {
        return restockAmount;
    }
}
