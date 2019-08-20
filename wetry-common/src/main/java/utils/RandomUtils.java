package utils;

import java.util.Random;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:47
 */
public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int nextInt(int start,int end){
        return start + RANDOM.nextInt(end - start);
    }
}
