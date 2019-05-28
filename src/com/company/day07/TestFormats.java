import java.util.Date;
import java.util.Calendar;
public class TestFormats {
    public static void main(String[] args) {
        String s1 = String.format("I hava %,10.2f bugs to fix", 100000.219324);
        System.out.println(s1);
        Date today = new Date();
        String s2 = String.format("%tA, %<tB  %<td", today);
        System.out.println(s2);
        String s3 = String.format("%tr", new Date());
        System.out.println(s3);
    }
}