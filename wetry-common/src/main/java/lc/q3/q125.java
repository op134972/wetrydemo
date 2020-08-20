package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-15 18:43
 */
public class q125 {

    /*
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 92.66%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 45.28%
     * 的用户
     */
    public boolean is(String s){

        if (s == null || s.length() == 1 || s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < arr.length && notLetter(arr[l])) {
                l++;
            }
            while (r >= 0 && notLetter(arr[r])) {
                r--;
            }
            if (l >= r) {
                return true;
            }
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean notLetter(char c) {
        return !Character.isLetter(c) && !(c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        q125 q125 = new q125();
        boolean b = q125.is("0P");
        System.out.println(b);
    }
}
