package guitar_order_system;

import java.util.Calendar;
import java.util.Date;

public class DateRange {
    private final Date todaysDate;

    public DateRange(Date todaysDate) {
        this.todaysDate = todaysDate;
    }

    private Date today() {
        return todaysDate;
    }

    private Date dateFrom(Date date, int days, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    Date startDate(int years) {
        return dateFrom(today(), -30, years);
    }

    Date endDate(int years) {
        return dateFrom(today(), 0, years);
    }
}
