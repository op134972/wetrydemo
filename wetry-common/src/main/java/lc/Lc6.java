package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangwc on 2019/3/7.
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Lc6 {

    /**
     * 成功
     * 显示详情
     * 执行用时: 53 ms, 在ZigZag Conversion的Java提交中击败了70.85% 的用户
     * 内存消耗: 52.6 MB, 在ZigZag Conversion的Java提交中击败了17.53% 的用户
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() == 1 || numRows == 1) {
            return s;
        }
        /**
         *numRow:行数
         * StringBuilder 表示每一行的字符串
         * 以四行为例：
         * 0,     6,     12
         * 1,   5 7,  11,13
         * 2, 4,  8,10,  14
         * 3,     9,     15
         */

        List<StringBuilder> row = new ArrayList<>();
        int gap = numRows - 2 + numRows;
        for (int i = 0; i < numRows; i++) {
            int start = i;
            StringBuilder sb = new StringBuilder();
            int step = i * 2;
            int i1 = gap - step;
            while (start < s.length()) {
                sb.append(s.charAt(start));
                if (i1 == 0) {
                    i1 = gap;
                }
                start += i1;
                if (i1 != gap) {
                    i1 = (gap - i1);
                }
            }
            row.add(sb);
        }

        StringBuilder ss = new StringBuilder();
        for (StringBuilder stringBuilder : row) {
            ss.append(stringBuilder.toString());
        }

        return ss.toString();
    }

    public static void main(String[] args) {
        Lc6 l = new Lc6();
        System.out.println(l.convert("AB", 1));
    }

}
