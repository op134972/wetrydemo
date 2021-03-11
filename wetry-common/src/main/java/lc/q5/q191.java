package lc.q5;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 21:12
 */
public class q191 {

    public int hammingWeight(int n) {

        int count = 0;
        int a = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & a) != 0) {
                count++;
            }
            a = a << 1;
        }

        return count;
    }

    public int hammingWeight1(int n) {

        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        q191 q191 = new q191();
        System.out.println(q191.hammingWeight(1 + 2 + 4 + 8 + 16));
    }
}
