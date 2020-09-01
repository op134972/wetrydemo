package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-14 00:52
 */
public class q91 {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 67.53%
     * 的用户
     */
    public int numDecodings(String s) {
        //12325 f(n) = f(n-1) + 1 + if([n&n-1] <= 26)f(n-2)

        //f(1) = f(0) + 1 = 1
        //f(2) = 1+1+f(0) = 2
        //f(3) = f(2)+1+f(1) = 4
        //f(4) = f(3)+1 = 5
        //f(5) = f(4)+1+f(2) = 10
        /*

        f(n) = if(n.n-1 <= 26){f(n-2)} + f(n-1)

        0的情况梳理：

        1202
        02不算
        0不算
        30\40、00 直接返回0

         */

        if (s.length() == 0 || s.equals("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();
        //res[i]表示i位之前，有多少种编码
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                if (arr[i] == '0') {
                    res[i] = 0;
                }else{
                    res[i] = 1;
                }
                continue;
            }


            if (arr[i] == '0') {//当前为是0
                if (arr[i - 1] == '0') {
                    //连续两个0，直接返回0
                    return 0;
                }else{
                    int val = (arr[i - 1] - '0') * 10 + arr[i] - '0';
                    if (val <= 26) {
                        res[i] = ((i - 2 < 0) ? 1 : res[i - 2]);
                    }else{
                        //存在30、40、50 这种，直接return 0
                        return 0;
                    }
                }
            }else{//当前为不是0
                if (arr[i - 1] == '0') {
                    res[i] = res[i - 1];
                }else{
                    int val = (arr[i - 1] - '0') * 10 + arr[i] - '0';
                    if (val <= 26) {
                        res[i] = res[i - 1] + ((i - 2 < 0) ? 1 : res[i - 2]);
                    }else{
                        res[i] =  res[i - 1];
                    }
                }
            }
        }

        return res[arr.length - 1];
    }

    private int fun(int[] res, int i) {
        if (i < 0) {
            return 0;
        }
        return res[i];
    }

    public static void main(String[] args) {
        q91 q91 = new q91();
//        System.out.println(q91.numDecodings("0"));
//        System.out.println(q91.numDecodings("1"));
//        System.out.println(q91.numDecodings("12"));
//        System.out.println(q91.numDecodings("120"));
//        System.out.println(q91.numDecodings("126"));
//        System.out.println(q91.numDecodings("1234"));
        System.out.println(q91.numDecodings("611"));
//        System.out.println(q91.numDecodings("121212121212121212121212"));

        System.out.println(Integer.valueOf("" + '2' + '6'));
    }
}
