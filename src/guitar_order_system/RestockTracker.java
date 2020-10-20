package guitar_order_system;

import java.util.List;
import java.util.stream.Collectors;

public class RestockTracker {
    private RestockCalculator restockCalculator;
    private List<Product> productList;

    public RestockTracker(RestockCalculator restockCalculator, List<Product> productList) {
        this.restockCalculator = restockCalculator;
        this.productList = productList;
    }

    public List<RestockItem> getRestockList() {
        return productList.stream()
                .filter(Product::needsRestocking)
                .map((product) -> new RestockItem(product.getId(), restockCalculator.getRestockAmount(product)))
                .collect(Collectors.toList());
    }

}
