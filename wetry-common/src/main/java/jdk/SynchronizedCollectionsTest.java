package jdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-22 21:11
 */
public class SynchronizedCollectionsTest {

    public static void main(String[] args) {
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
        System.out.println(map);
    }
}
