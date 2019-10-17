package cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-28 10:46
 */
public class a_LRUMap extends LinkedHashMap {

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return false;
    }
}
