package caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-30 18:28
 * 缓存污染测试
 */
public class CachePolluteTest {


    public static void main(String[] args) throws ExecutionException {
        test4GCache();

        test4CCache();
    }

    private static void test4CCache() {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);

        com.github.benmanes.caffeine.cache.Cache<String, List<Integer>> gCache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
        gCache.put("list", list);
        List<Integer> listFromGCache = gCache.getIfPresent("list");
        System.out.println(listFromGCache.toString());
        //移除一个元素，再次获取
        listFromGCache.remove(0);
        System.out.println(listFromGCache.toString());
        listFromGCache = gCache.getIfPresent("list");

        System.out.println("getFromCacheAgain:"+listFromGCache.toString());
        System.out.println("Caffeine cache exists cache pollute risk...");
    }

    private static void test4GCache() throws ExecutionException {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);

        Cache<String, List<Integer>> gCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
        gCache.put("list", list);
        List<Integer> listFromGCache = gCache.get("list", new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                return list;
            }
        });
        System.out.println(listFromGCache.toString());
        //移除一个元素，再次获取
        listFromGCache.remove(0);
        System.out.println(listFromGCache.toString());
        listFromGCache = gCache.get("list", new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                return list;
            }
        });
        System.out.println("getFromCacheAgain:"+listFromGCache.toString());
        System.out.println("google cache exists cache pollute risk...");
    }
}
