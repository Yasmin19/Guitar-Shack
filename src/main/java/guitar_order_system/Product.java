package guitar_order_system;

public class Product implements Stock {
    private int stock;
    private int leadTime;
    private int outstandingOrders;
    private AverageDailySales averageDailySales;
    private int id;

    public Product(int id, int stock, int leadTime, int outstandingOrders, AverageDailySales averageDailySales) {
        this.id = id;
        this.stock = stock;
        this.leadTime = leadTime;
        this.outstandingOrders = outstandingOrders;
        this.averageDailySales = averageDailySales;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean needsRestocking() {
        return stock < restockThreshold();
    }

    int restockThreshold() {
        return (int) Math.ceil(leadTime * averageDailySales.averageSales(this) - (double) outstandingOrders);
    }
}
