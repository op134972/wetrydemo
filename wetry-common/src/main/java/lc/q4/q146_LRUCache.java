package lc.q4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-21 09:33
 *
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2
//        *
//        *cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1);       // 返回  1
//        *cache.put(3,3);    // 该操作会使得关键字 2 作废
//        *cache.get(2);       // 返回 -1 (未找到)
//        *cache.put(4,4);    // 该操作会使得关键字 1 作废
//        *cache.get(1);       // 返回 -1 (未找到)
//        *cache.get(3);       // 返回  3
//        *cache.get(4);       // 返回  4
*/
public class q146_LRUCache {

    private LinkedHashSet<Integer> queue;
    private Map<Integer, Integer> cache;
    private int capacity ;

    public q146_LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity * 3 / 4);
        this.queue = new LinkedHashSet<>(capacity * 3 / 4);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!queue.contains(key)) {
            return -1;
        }
        queue.remove(key);
        queue.add(key);
        Integer val = cache.get(key);
        return val != null ? val : -1;
    }

    public void put(int key, int value) {
        //更新queue
        queue.remove(key);
        queue.add(key);
        if (queue.size() > capacity) {
            Iterator<Integer> iterator = queue.iterator();
            if (iterator.hasNext()) {
                Integer next = iterator.next();
                queue.remove(next);
                cache.remove(next);
            }
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {

        /**
         * ["LRUCache","put","put","get","put","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         *
         * 输出：
         * [null,null,null,1,null,2,null,-1,3,4]
         * 预期结果：
         * [null,null,null,1,null,-1,null,-1,3,4]
         */
        q146_LRUCache q146 = new q146_LRUCache(10);
        for (int i = 0; i < 100; i++) {
            q146.put(i, i);
        }
    }
}
