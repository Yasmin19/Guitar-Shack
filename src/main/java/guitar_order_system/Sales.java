package guitar_order_system;

import java.util.Date;

public interface Sales {
    int total(int productID, Date startDate, Date endDate);
}
