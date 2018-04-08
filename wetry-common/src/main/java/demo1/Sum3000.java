package demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sum3000 {

    public static void main(String[] args) {
        int[] arr = {235, 1999, 866, 2000, 756, 500, 867, 4234};//test array
        Map<Integer, Integer> res = nearestTo3000(arr);

        Set<Map.Entry<Integer, Integer>> entries = res.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue()+" | sum is "+ (entry.getValue()+entry.getKey()));
        }
    }
    /*
    1、map的思想
     */
    public static Map<Integer, Integer> nearestTo3000(int[] arr) {
        int[] temp = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] = 1;
        }
        Map<Integer, Integer> res = new HashMap<>();
        int dis = 0;//3000-dis，不等于3000 dis++，3000-dis会递减至2999...
        while (res.size() == 0) {
            int sum = 3000 - dis;
            for (int i = 0; i < arr.length; i++) {
                if ((sum - arr[i]) >= 0 && temp[sum - arr[i]] == 1) {
                    if (!res.containsKey(sum - arr[i])) {
                        res.put(arr[i], sum - arr[i]);
                    }
                }
            }
            dis++;
        }
        return res;
    }
}
