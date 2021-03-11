package rateLimit;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

public class LeakyBucketLimiter extends AbstractLimiter {

    /**
     * 我们的漏斗
     */
    private final LeakyBucket leakyBucket;

    /**
     * 构造器 , 输入每秒最大流量
     *
     * @param MAX_FlOW 最大流量
     */
    public LeakyBucketLimiter(int MAX_FlOW) {
        super(MAX_FlOW);
        this.leakyBucket = new LeakyBucket(MAX_FlOW);
    }

    @Override
    public void limit(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            // 1. 获取桶当前水的大小
            int size = leakyBucket.bucket.size();

            // 2. 比较桶里的水是否满了
            if (size < leakyBucket.waterSize) {

                // 没有满我们就将水放进去,其实这里put也行 , offer也行 , 看需求
                leakyBucket.bucket.put(new Water(request, response, chain));
            }
        } catch (InterruptedException e) {
            //
        }
    }

    static class LeakyBucket {

        /**
         * 能放多少水,其实就是队列大小
         */
        final int waterSize;

        /**
         * 我们的放水的桶
         */
        final ArrayBlockingQueue<Water> bucket;

        public LeakyBucket(int MAX_FlOW) {
            this.waterSize = MAX_FlOW;
            bucket = new ArrayBlockingQueue<>(this.waterSize);

            /**
             * 模拟消费 , 1S只能过去100个 ,说明 100ms 可以消耗10个, 看你的颗粒度
             */
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // 100ms 流出去10个
                    for (int i = 0; i < (waterSize / 10); i++) {
                        try {
                            // 流出的水
                            Water water = bucket.take();

                            // 执行掉
                            water.chain.doFilter(water.request, water.response);
                        } catch (Exception e) {
                            //
                        }
                    }
                }
            }, 0, 100);
        }
    }


    /**
     * 我们的节点对象, 其实可以称之为 成功注入的水 , 等着被漏桶流出去
     */
    static class Water {

        private ServletRequest request;

        private ServletResponse response;

        private FilterChain chain;

        public Water(ServletRequest request, ServletResponse response, FilterChain chain) {
            this.request = request;
            this.response = response;
            this.chain = chain;
        }
    }
}
