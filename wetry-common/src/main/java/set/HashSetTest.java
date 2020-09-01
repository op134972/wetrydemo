package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-30 21:39
 */
public class HashSetTest {


    public static void main(String[] args) {
        Set<Long> set = new HashSet<>(4);
        set.add(new Long(833));

        System.out.println(set.contains(833L));

    }
}
