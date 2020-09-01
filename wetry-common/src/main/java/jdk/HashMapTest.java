package jdk;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-10 10:21
 */
public class HashMapTest {


    public static void main(String[] args) {

        HashMap<Long, String> map = new HashMap<>();

        //1对应null
        map.put(1L, null);
        System.out.println("before computeIfAbsent:" + map);
        //absent是指key对应的value不为null
        String s1 = map.computeIfAbsent(1L, String::valueOf);

        //所以此处打印出来的key1:value:1 而不是value:null
        System.out.println("after computeIfAbsent:" + map);


        System.out.println("-------------------------------------------------");

        map.put(1L, "2");
        System.out.println("before computeIfPresent:" + map);
        //如果存在，更新为新值
        map.computeIfPresent(1L, (aLong, s) -> String.valueOf(aLong));

        System.out.println("after computeIfPresent:" + map);


        System.out.println("-------------------------------------------------");


        map.remove(1L);
        //不管存不存在，都是新值，作用类似于put，但是put返回的是旧值，compute返回的是新值
        System.out.println(map);

        map.put(1L, "oldValue");
        String put = map.put(1L, "put2");
        System.out.println("put return:" + put + ", after put:" + map);

        map.put(1L, "oldValue");
        String compute = map.compute(1L, new BiFunction<Long, String, String>() {
            @Override
            public String apply(Long aLong, String s) {
                return "compute"+String.valueOf(aLong);
            }
        });
        System.out.println("compute return:" + compute + ", after compute:" + map);


        ConcurrentHashMap<Long, Long> cMap = new ConcurrentHashMap<>();
        cMap.put(1L, 1L);

    }

}
