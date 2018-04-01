package demo.sso.utils;

import java.util.Random;

public class IdUtils {

    /*

        生成唯一主键
     */
    public static synchronized String genUniqueId(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    };
}
