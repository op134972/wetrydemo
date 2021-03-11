package lc.hard;

/**
 * @Author: tangwenchuan
 * @Date: 2020-10-19 20:10
 */
public class q60 {

    public String getPermutation(int n, int k) {


        int[] fac = new int[n];
        boolean[] used = new boolean[n];
        StringBuilder res = new StringBuilder();

        /**
         * 6,2,1
         *
         * 6
         */
        for (int i = 0; i < n; i++) {
            if (fac[i] > k) {
                res.append(getAndUse(used, 0, n));
            } else {// k>= fac[i]
                int ll = k / fac[i + 1];
                res.append(getAndUse(used, ll, n));
                k = k % fac[i - 1];
            }
        }

        return res.toString();
    }

    private String getAndUse(boolean[] used, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (!used[i]) {
                used[i] = true;
                return String.valueOf(i + 1);
            }
        }
        return "";
    }
}
