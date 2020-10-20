package guitar_order_system;

public class ProductSalesRate implements AverageDailySales {
    private Sales sales;
    private DateRange dateRange;

    public ProductSalesRate(Sales sales, DateRange dateRange) {
        this.sales = sales;
        this.dateRange = dateRange;
    }

    @Override
    public double getAverageSales(Product product) {
        int monthSales = sales.total(product.getId(), dateRange.startDate(0), dateRange.endDate(0));

        if (monthSales == 0) {
            monthSales = sales.total(product.getId(), dateRange.startDate(-1), dateRange.endDate(-1));
        }
        return monthSales / 30.0;
    }

}
