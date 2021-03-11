package lc.q5;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-26 12:35
 */
public class q204 {

    /**
     * AC 可优化
     * 12 = 2*6
     * 12 = 3*4
     * 12 = 根号12*根号12
     * 12 = 4*3
     * 12 = 6*2
     *
     * 只需要判断 [2,根号12]之间有没有能整除12的数，就能判定12是不是质数
     *
     * i  [2,根号2]
     */
    public int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }

        int[] arr = new int[n + 1];

        int res = 0;
        for (int i = 2; i < n; i++) {
            int temp = i;
            int mul = 2;
            while (temp < n) {
                arr[temp]++;
                temp = i * mul++;
            }
            if (arr[i] == 1) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        q204 q204 = new q204();
        System.out.println(q204.countPrimes(2));
        System.out.println(q204.countPrimes(5));
        System.out.println(q204.countPrimes(10));
        System.out.println(q204.countPrimes(30));
    }

}
