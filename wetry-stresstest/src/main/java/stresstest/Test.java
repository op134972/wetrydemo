package stresstest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 22:08
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal b = new BigDecimal(0.4);
        int i = b.setScale(0, RoundingMode.DOWN).intValue();

        System.out.println(i);
    }
}
