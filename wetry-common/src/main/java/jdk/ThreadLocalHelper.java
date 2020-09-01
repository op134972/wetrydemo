package jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-10 20:40
 */
public class ThreadLocalHelper {

    public static final Map<String, ThreadLocal> tlMap = new HashMap<>(16);

    public static <T> T get(String name,Class<T> clazz) {
        ThreadLocal<T> threadLocal = tlMap.get(name);
        if (threadLocal == null) {
            return null;
        }
        return threadLocal.get();
    }

    public static <T> void set(String name ,T val){
        ThreadLocal<T> threadLocal = tlMap.computeIfAbsent(name, s -> new ThreadLocal<>());
        threadLocal.set(val);
    }

    public static void remove(String name){
        ThreadLocal threadLocal = tlMap.get(name);
        if (threadLocal != null) {
            threadLocal.remove();
        }
    }
}
