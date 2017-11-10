package guavatest;


import com.google.common.collect.*;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * guava 集合的创建
 */
public class Demo1 {
    public static void main(String[] args) {


        /**
         * guava的优点：
         * 1、简化创建和初始化
         * 2、不变性
         * 3、新的集合类型   允许重复键的map
         */

        //旧
        Map<String,String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();


        //guava创建
        ConcurrentMap<Object, Object> map1 = Maps.newConcurrentMap();
        HashMap<Object, Object> map2 = Maps.newHashMap();
        ArrayList<Object> objects = Lists.newArrayList();
        HashSet<Object> set1 = Sets.newHashSet();
        Integer[] arrays = ObjectArrays.newArray(Integer.class, 10);

        /**
         * 集合初始化
         */
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        System.out.println(strings.size());

        //创建不可变map    `ImmutableMap.of(key,value,key,value)`
        ImmutableMap<String, String> of = ImmutableMap.of("asd", "sada", "adf", "dasfa");

        //简化集合初始化
        ArrayList<Integer> integers = Lists.newArrayList(new Integer(1), new Integer(2));
        HashSet<Integer> integers1 = Sets.newHashSet(new Integer(1), new Integer(2));
        ImmutableMap<String, Integer> map3 = ImmutableMap.of("", new Integer(1), "", new Integer(2));

        //。。。
    }
}
