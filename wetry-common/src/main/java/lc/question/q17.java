package lc.question;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangwc on 2019/3/13.
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class q17 {

    public static Map<Character, Character[]> map = new HashMap();

    static {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    /**
     * 成功
     * 显示详情
     * 执行用时 : 5 ms, 在Letter Combinations of a Phone Number的Java提交中击败了22.51% 的用户
     * 内存消耗 : 37.8 MB, 在Letter Combinations of a Phone Number的Java提交中击败了0.82% 的用户
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        char[] chars = digits.toCharArray();
        for (char c : chars) {
            Character[] characters = map.get(c);
            fillChar(res, characters);
        }

        return res;
    }

    private void fillChar(List<String> res, Character[] characters) {
        List<String> temp = new ArrayList<>(res.size() * characters.length);
        if (res.size() == 0) {
            for (Character character : characters) {
                res.add(String.valueOf(character));
            }
            return;
        }
        for (String s : res) {
            for (Character c : characters) {
                temp.add(s + c);
            }
        }
        res.clear();
        res.addAll(temp);
    }

    public static void main(String[] args) {
        System.out.println(new q17().letterCombinations("23").toString());
    }
}
