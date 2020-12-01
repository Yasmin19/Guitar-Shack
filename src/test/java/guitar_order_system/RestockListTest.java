package guitar_order_system;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestockListTest {

    @Test
    public void nothingNeedsRestocking() {
        RestockTracker restockTracker = new RestockTracker(null, Arrays.asList(new Product(757, 6, 10, 0, (product) -> 0.5)));
        List<RestockItem> restockList = restockTracker.restockList();
        assertEquals(0, restockList.size());
    }

    @Test
    public void oneItemNeedsRestocking() {
        RestockCalculator restockCalculator = product -> 1;
        Stock product = new Product(757, 4, 10, 0, (product1) -> 0.5);
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Arrays.asList(product));
        List<RestockItem> restockList = restockTracker.restockList();
        assertEquals(1, restockList.size());
        assertEquals(product, restockList.get(0).getProduct());
        assertEquals(1, restockList.get(0).getRestockAmount());
    }

    @Test
    public void multipleItemsNeedRestocking() {
        Stock stratocaster = new Product(757, 4, 10, 0, (product) -> 0.5);
        Stock lesPaulClassic = new Product(811, 9, 10, 0, (product) -> 1);
        Stock telecaster = new Product(449, 3, 10, 0, (product) -> 0.3);
        RestockCalculator restockCalculator = product -> 0;
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Arrays.asList(stratocaster, lesPaulClassic, telecaster));
        List<RestockItem> restockList = restockTracker.restockList();
        assertEquals(2, restockList.size());
        assertEquals(stratocaster, restockList.get(0).getProduct());
        assertEquals(lesPaulClassic, restockList.get(1).getProduct());
    }

}
