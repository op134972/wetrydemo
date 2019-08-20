package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-24 23:21
 *
 *
 * concurrentHashMap一定是线程安全的吗？以下这段代码证明了不是的。
 *
 * 这篇博文说明了原因和解决：http://www.imooc.com/article/285576
 */
public class ConcurrentHashMapTest {
        private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//    private static Map<String, Integer> map = new HashMap<>();

    public void add(String key) throws InterruptedException {
        Integer val = map.get(key);
        if (val == null) {
            map.put(key, 1);
        } else {
            map.put(key, val + 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMapTest test = new ConcurrentHashMapTest();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    test.add("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    test.add("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        System.out.println(map.get("1"));
    }
}
