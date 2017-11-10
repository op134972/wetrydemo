package javaapi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    private static final ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        System.out.println(df.get().format(new Date()));
    }
}
