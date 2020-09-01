package lc.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-18 19:41
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class q118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> subRes = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    subRes = new ArrayList<>();
                    subRes.add(1);
                }else{
                    List<Integer> preRes = res.get(i-1);
                    if (j == 0 || j == preRes.size()) {
                        subRes.add(1);
                    }else{
                        subRes.add(preRes.get(j - 1) + preRes.get(j));
                    }
                }
            }
            res.add(subRes);
        }

        return res;
    }

    public static void main(String[] args) {
        q118 q118 = new q118();
        List<List<Integer>> res = q118.generate(10);
        System.out.println(res.toString());
    }
}
