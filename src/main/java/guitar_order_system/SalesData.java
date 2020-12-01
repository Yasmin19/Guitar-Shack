package guitar_order_system;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesData implements Sales {

    private final DataSource web;
    String urlTemplate = "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales?productId=%s&startDate=%s&endDate=%s&action=total";

    public SalesData(DataSource web) {
        this.web = web;
    }

    @Override
    public int total(int productID, Date startDate, Date endDate) {
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
        String formattedUrl = String.format(urlTemplate, productID, format.format(startDate), format.format(endDate));
        String json = web.fetchJson(formattedUrl);
        ProductSalesTotal targetObject = new Gson().fromJson(json, ProductSalesTotal.class);
        return targetObject.total;
    }

}
