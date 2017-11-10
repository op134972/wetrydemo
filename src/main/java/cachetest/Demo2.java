package cachetest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo2 {


    /**
     * Cacheloader：配置一个通用的方法，在key不存在时的措施，相较于CallableCache更有全局性。
     */
    @Test
    public void CacheLoaderTest() throws ExecutionException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.HOURS)//指定时间没有写，则回收
                .expireAfterAccess(3, TimeUnit.HOURS)//指定时间没有读取，则回收
                .maximumSize(10000)//缓存个数
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return getFromDB(key);
                    }

                    private String getFromDB(String key) {
                        System.out.println("当缓存中不存在时，以某种方式获取key");
                        return key + "'s value";
                    }
                });
        System.out.println(loadingCache.get("testkey"));//第1次从DB取
        System.out.println(loadingCache.get("testkey"));//第2次get, 此时缓存中存在key 不会从DB取
        System.out.println(loadingCache.get("testkey"));//第3次get, 此时缓存中存在key 不会从DB取

        ConcurrentMap<String, String> stringStringConcurrentMap = loadingCache.asMap();//返回该缓存中的map视图
        loadingCache.invalidateAll();//清除缓存
        System.out.println(loadingCache.get("testkey"));//清除缓存之后从DB取

    }

    /**
     * 针对每个key，给一个  "获取缓存-如果没有-则计算"[get-if-absent-compute] 的原子语义
     * @throws ExecutionException
     */
    @Test
    public void CallableCacheTest() throws ExecutionException {
        Cache<String, String> callableCache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String key1 = callableCache.get("key1", new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("当缓存中不存在时，以某种方式获取key");
                return "key1's value";
            }
        });
        String anotherKey1 = callableCache.get("key1", new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("当缓存中不存在时，以某种方式获取key");
                return "key2's value";
            }
        });

        System.out.println(key1);
        System.out.println(anotherKey1);//此时在缓存中已经存在key1，不会执行callable方法

        /**
         * Cache中的一些方法：
         * ref：http://blog.csdn.net/liangrui1988/article/details/46402093
         */
    }
}
