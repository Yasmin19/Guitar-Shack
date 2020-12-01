package guitar_order_system;

public class Product implements Stock {
    private int currentStock;
    private int leadTime;
    private int outstandingOrders;
    private AverageDailySales averageDailySales;
    private int productID;

    public Product(int productID, int currentStock, int leadTime, int outstandingOrders, AverageDailySales averageDailySales) {
        this.productID = productID;
        this.currentStock = currentStock;
        this.leadTime = leadTime;
        this.outstandingOrders = outstandingOrders;
        this.averageDailySales = averageDailySales;
    }

    public int getId() {
        return productID;
    }

    @Override
    public boolean needsRestocking() {
        return currentStock < restockThreshold();
    }

    int restockThreshold() {
        return (int) Math.ceil(leadTime * averageDailySales.averageSales(this) - (double) outstandingOrders);
    }
}
