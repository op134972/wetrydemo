package lc.question;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangwc on 2019/3/4.
 *
 *
 *
 */
public class Lc560_ {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                ret += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ret;
    }

    public static void main(String[] args) {
        Lc560_ lc = new Lc560_();
        int[] arr  = {1,2,3,2};
        System.out.println(lc.subarraySum(arr,3));
    }
}
