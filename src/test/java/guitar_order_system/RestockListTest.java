package guitar_order_system;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestockListTest {

    @Test
    public void nothingNeedsRestocking() {
        RestockTracker restockTracker = new RestockTracker(null, Arrays.asList(new Product(757, 6, 10, 0, (product) -> 0.5)));
        List<RestockItem> restockList = restockTracker.getRestockList();
        assertEquals(0, restockList.size());
    }

    @Test
    public void oneItemNeedsRestocking() {
        RestockCalculator restockCalculator = product -> 1;
        Product product = new Product(757, 4, 10, 0, (product1) -> 0.5);
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Arrays.asList(product));
        List<RestockItem> restockList = restockTracker.getRestockList();
        assertEquals(1, restockList.size());
        assertEquals(product.getId(), restockList.get(0).getProductId());
        assertEquals(1, restockList.get(0).getRestockAmount());
    }

    @Test
    public void multipleItemsNeedRestocking() {
        Product stratocaster = new Product(757, 4, 10, 0, (product) -> 0.5);
        Product lesPaulClassic = new Product(811, 9, 10, 0, (product) -> 1);
        Product telecaster = new Product(449, 3, 10, 0, (product) -> 0.3);
        RestockCalculator restockCalculator = product -> 0;
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Arrays.asList(stratocaster, lesPaulClassic, telecaster));
        List<RestockItem> restockList = restockTracker.getRestockList();
        assertEquals(2, restockList.size());
        assertEquals(stratocaster.getId(), restockList.get(0).getProductId());
        assertEquals(lesPaulClassic.getId(), restockList.get(1).getProductId());
    }

}
