package guitar_order_system;

import java.util.List;
import java.util.stream.Collectors;

public class RestockTracker {
    private RestockCalculator restockCalculator;
    private List<Stock> stockList;

    public RestockTracker(RestockCalculator restockCalculator, List<Stock> stockList) {
        this.restockCalculator = restockCalculator;
        this.stockList = stockList;
    }

    public List<RestockItem> restockList() {
        return stockList.stream()
                .filter(Stock::needsRestocking)
                .map((product) -> new RestockItem(product, restockCalculator.getRestockAmount(product)))
                .collect(Collectors.toList());
    }

}
