package lru;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tangwenchuan
 * @Date: 2019-09-03 21:51
 */
public class SimpleLruCache<K,V>{

    private int size;
    private ConcurrentHashMap<K, V> map;
    private Node head;


    class Node{

    }
}
