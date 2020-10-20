package guitar_order_system;

public class Product {
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

    boolean needsRestocking() {
        return currentStock < restockThreshold();
    }

    int restockThreshold() {
        return (int) Math.ceil(leadTime * averageDailySales.getAverageSales(this) - (double) outstandingOrders);
    }
}
