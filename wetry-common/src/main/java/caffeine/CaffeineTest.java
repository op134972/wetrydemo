package caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-28 14:28
 */
public class CaffeineTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*手动加载*/
        Cache<String, String> cache = Caffeine.newBuilder().maximumSize(10_1000).expireAfterWrite(1, TimeUnit.MINUTES).build();
        String val = cache.get("0", s -> s);
        System.out.println(val);


        /*同步cache*/
        LoadingCache<String, String> syncCache = Caffeine.newBuilder().maximumSize(10_1000).expireAfterWrite(1, TimeUnit.MINUTES).build(CaffeineTest::createExpensiveGraph);

        val = syncCache.get("1");
        System.out.println(val);
        val = syncCache.get("1");
        System.out.println(val);

        /*异步cache*/
        AsyncLoadingCache<String, String> asyncCache = Caffeine.newBuilder().maximumSize(10_1000).expireAfterWrite(1, TimeUnit.MINUTES).buildAsync(CaffeineTest::createExpensiveGraph);
        CompletableFuture<String> ifPresent = asyncCache.getIfPresent("2");
        CompletableFuture<String> stringCompletableFuture = asyncCache.get("2");
        System.out.println(stringCompletableFuture.get());
        val = asyncCache.get("2").get();
        System.out.println(val);

    }

    private static String createExpensiveGraph(String key) {
        return key;
    }
}
