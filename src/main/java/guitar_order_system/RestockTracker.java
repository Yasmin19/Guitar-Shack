package guitar_order_system;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestockTracker {
    private RestockCalculator restockCalculator;
    private Set<Integer> soldProductIds;
    private Warehouse warehouse;

    public RestockTracker(RestockCalculator restockCalculator, Set<Integer> soldProductIds, Warehouse warehouse) {
        this.restockCalculator = restockCalculator;
        this.soldProductIds = soldProductIds;
        this.warehouse = warehouse;
    }

    public List<RestockItem> restockList() {
        return soldProductIds.stream()
                .map((id) -> warehouse.productById(id))
                .filter(Stock::needsRestocking)
                .map((product) -> new RestockItem(product, restockCalculator.getRestockAmount(product)))
                .collect(Collectors.toList());
    }

}
