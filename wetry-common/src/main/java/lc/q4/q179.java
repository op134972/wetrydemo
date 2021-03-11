package lc.q4;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 13:36
 */
public class q179 {

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }else{
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                if (s1.compareTo(s2) > 0) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            res.append(arr[arr.length - 1 - i]);
        }

        if (res.charAt(0) == '0') {
            return "0";
        }

        return res.toString();
    }

    public static void main(String[] args) {
        /**
         * 输入: [3,30,34,5,9]
         * 输出: 9534330
         */
        q179 q179 = new q179();
        System.out.println(q179.largestNumber(new int[]{1,0}));
        System.out.println(q179.largestNumber(new int[]{0,0,0}));
        System.out.println(q179.largestNumber(new int[]{0,0,2,13,3,14,32,20}));
        System.out.println(q179.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
