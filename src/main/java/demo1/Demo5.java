package demo1;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Demo5 {
    public static final Pattern PhoneNoPatten = Pattern.compile("^1[0-9]{10}$");

    public static boolean isPhoneNo(String phone){
        boolean result = false;
        if (StringUtils.isNotEmpty(phone)) {
            result = PhoneNoPatten.matcher(phone).matches();
        }
        return result;
    }
    static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//            list.add(i);
//        }

        System.out.println(isPhoneNo("12478558554"));


        Date d = new Date();
        System.out.println(d.getTime());
    }
}