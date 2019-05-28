import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 6, 3, 6, 30);
        long day1 = cal.getTimeInMillis();
        day1 += 1000 * 60 * 60;
        cal.setTimeInMillis(day1);
        System.out.println("new time " + cal.get(cal.HOUR_OF_DAY));
        cal.add(cal.DATE, 35);
        System.out.println("add 35 days " + cal.getTime());
        cal.roll(cal.DATE, 35);
        System.out.println("roll 35 days " + cal.getTime());
        cal.set(cal.DATE, 1);
        System.out.println("set to 1 " + cal.getTime());
    }
}