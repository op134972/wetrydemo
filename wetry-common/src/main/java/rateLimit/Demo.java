package rateLimit;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Demo {

    @Test
    public void test() {
        
        // 过滤器
        Filter filter = new Filter() {
            AbstractLimiter limit = null;

            @Override
            public void init() {
                // 入口 ,我们都是每秒限制 100个请求
                limit = new LeakyBucketLimiter(100);
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
                limit.limit(request, response, chain);
            }
        };

        // 过滤器初始化
        filter.init();

        // 计时器
        long start = System.currentTimeMillis();
        
        // 计数器
        AtomicInteger integer = new AtomicInteger(0);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 模拟4000次请求
        IntStream.range(0, 4000).forEach(e -> {
            try {
                // 模拟请求延迟
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e1) {
                //
            }

            // 多线程执行
            pool.execute(()->{
                filter.doFilter(new ServletRequest("" + e), new ServletResponse(), new FilterChain() {
                    @Override
                    public void doFilter(ServletRequest request, ServletResponse response) {
                        // 回调接口
                        integer.incrementAndGet();
                        System.out.println("请求 : "+request.getMsg() + " 通过, 执行线程 "+Thread.currentThread().getName());
                    }
                });
            });
        });

        System.out.println("总耗时" + (System.currentTimeMillis() - start));
        System.out.println("一共通过 : " + integer.get());
    }
}
