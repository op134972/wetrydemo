package lc.question;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-03 10:32
 */
public class q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>(strs.length * 2);
        for (String str : strs) {
            Integer myHash = getHash(str);
            List<String> list = map.computeIfAbsent(myHash, k -> new ArrayList<>(strs.length));
            list.add(str);
        }
        for (List<String> value : map.values()) {

        }
        return new ArrayList<>(map.values());
    }

    private Integer getHash(String str) {
        return str.hashCode() + str.length();
    }


}
