package demo.sso.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    public static String getCurrentTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(now);
    }
    public static String getCurrentYear(){
        Calendar now = Calendar.getInstance();
        return String.valueOf(now.get(Calendar.YEAR));
    }
    public static String getCurrenMonth(){
        Calendar now = Calendar.getInstance();
        return String.valueOf(now.get(Calendar.MONTH) + 1);
    }
    public static String getCurrentDay(){
        Calendar now = Calendar.getInstance();
        return String.valueOf(now.get(Calendar.DAY_OF_MONTH));
    }
}
