package guitar_order_system;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RestockListTest {

    @Test
    public void nothingNeedsRestocking() {
        Product product = new Product(757, 6, 10, 0, (product1) -> 0.5);
        Warehouse warehouse = new Warehouse() {
            @Override
            public Stock productById(int productId){
                return product;
            }
        };
        RestockTracker restockTracker = new RestockTracker(null, Set.of(757), warehouse);
        List<RestockItem> restockList = restockTracker.restockList();
        assertEquals(0, restockList.size());
    }

    @Test
    public void oneItemNeedsRestocking() {
        RestockCalculator restockCalculator = product -> 1;
        Stock product = new Product(757, 4, 10, 0, (product1) -> 0.5);
        Warehouse warehouse = new Warehouse() {
            @Override
            public Stock productById(int productId){
                return product;
            }
        };
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Set.of(757), warehouse);
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

        Queue<Stock> stockQueue = new LinkedList<>();
        stockQueue.add(stratocaster);
        stockQueue.add(lesPaulClassic);
        stockQueue.add(telecaster);
        Warehouse warehouse = new Warehouse() {
            @Override
            public Stock productById(int productId) {
                return stockQueue.remove();
            }
        };
        RestockCalculator restockCalculator = product -> 0;
        RestockTracker restockTracker = new RestockTracker(restockCalculator, Set.of(757, 811, 449), warehouse);
        List<RestockItem> restockList = restockTracker.restockList();
        assertEquals(2, restockList.size());
        assertEquals(stratocaster, restockList.get(0).getProduct());
        assertEquals(lesPaulClassic, restockList.get(1).getProduct());
    }
}
