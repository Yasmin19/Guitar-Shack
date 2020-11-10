package guitar_order_system;

import com.google.gson.Gson;

import java.util.Date;

public class SalesData implements Sales {

    private final DataSource web;
    String urlString = "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales?productId=811&startDate=7%2F17%2F2019&endDate=7%2F27%2F2019&action=total";

    public SalesData(DataSource web) {
        this.web = web;
    }

    @Override
    public int total(int productID, Date startDate, Date endDate) {
        String json = web.fetchJson(urlString);
        ProductSalesTotal targetObject = new Gson().fromJson(json, ProductSalesTotal.class);
        return targetObject.total;
    }

}
