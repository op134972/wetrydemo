package cache;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-28 10:47
 */
public class b_LRUMapTest {
    public static void main(String[] args) {
        a_LRUMap lru = new a_LRUMap();

        lru.put(1, 1);

        System.out.println(lru.toString());
    }
}
