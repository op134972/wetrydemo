package cachetest;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class PriorityQueue {

    @Test
    public void loadingtest(){
        Cache<Object, Object> cache = CacheBuilder.newBuilder().maximumSize(1000).build();

        cache.invalidateAll();
    }

    /**
     * CacheLoader
     */
    @Test
    public void loadingCache()
    {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).build(new CacheLoader<String, String>()
                {
                    @Override
                    public String load(String key) throws Exception
                    {
                        System.out.println("key:"+key);
                        if("key".equals(key)){
                            return "key return result";
                        }else{
                            return "get-if-absent-compute";
                        }


                    }

                });

        String resultVal = null;
        try {
            resultVal = graphs.get("key");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(resultVal);
    }

    /**
     *
     * Callable
     * 在使用缓存前，首先问自己一个问题：有没有合理的默认方法来加载或计算与键关联的值？如果有的话，你应当使用CacheLoader。如果没有，
     * 或者你想要覆盖默认的加载运算，同时保留"获取缓存-如果没有-则计算"[get-if-absent-compute]的原子语义，
     * 你应该在调用get时传入一个Callable实例
     * 。缓存元素也可以通过Cache.put方法直接插入，但自动加载是首选的，因为它可以更容易地推断所有缓存内容的一致性。
     */
    @Test
    public void callablex() throws ExecutionException
    {

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).build();

        cache.put("result","heihei");

        String result = cache.get("key", new Callable<String>()
        {
            public String call()
            {
                return "result";
            }
        });
        System.out.println(result);
    }

    /**
     * 从LoadingCache查询的正规方式是使用get(K)方法。这个方法要么返回已经缓存的值，要么使用CacheLoader向缓存原子地加载新值。
     * 由于CacheLoader可能抛出异常，LoadingCache.get(K)也声明为抛出ExecutionException异常。
     * 如果你定义的CacheLoader没有声明任何检查型异常
     * ，则可以通过getUnchecked(K)查找缓存；但必须注意，一旦CacheLoader声明了检查型异常
     * ，就不可以调用getUnchecked(K)。
     *
     * @throws ExecutionException
     */
    @Test
    public void capacity()
    {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumWeight(100000).weigher(new Weigher<String, String>()
                {
                    public int weigh(String k, String g)
                    {
                        return 100;
                    }
                }).build(new CacheLoader<String, String>()
                {
                    public String load(String key)
                    { // no checked exception
                        // return createExpensiveGraph(key);
                        return "xxxx";
                    }
                });

    }

}
