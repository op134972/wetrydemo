package rateLimit;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TokenBucketLimiter extends AbstractLimiter {

    /**
     * 令牌桶
     */
    private final TokenBucket tokenBucket;

    /**
     * 构造器 , 输入每秒最大流量
     *
     * @param MAX_FlOW 最大流量
     */
    public TokenBucketLimiter(int MAX_FlOW) {
        super(MAX_FlOW);
        this.tokenBucket = new TokenBucket(MAX_FlOW);
    }


    @Override
    public void limit(ServletRequest request, ServletResponse response, FilterChain chain) {
        /**
         * 这里我们就不使用 take的阻塞思想了 ,直接poll去拉去 ,然后等待5mS ,  如果拉去不到直接返回失败 , 其实等待的长了点
         */
        try {
            // 尝试去获取一个令牌
            Token token = tokenBucket.bucket.poll(5, TimeUnit.MILLISECONDS);
            
            // 拿到通过
            if (null != token) {
                chain.doFilter(request, response);
            }

        } catch (Exception e) {
            //
        }

    }


    /**
     * 令牌桶
     */
    private static class TokenBucket {
        /**
         * 令牌存放的位置 , 用一个队列维护
         */
        private final ArrayBlockingQueue<Token> bucket;

        /**
         * 桶最多存放多少个令牌
         */
        private final int tokenSize;

        public TokenBucket(int MAX_FlOW) {
            this.tokenSize = MAX_FlOW;
            this.bucket = new ArrayBlockingQueue<>(this.tokenSize);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    for (int x = 0; x < (tokenSize / 10); x++) {
                        try {
                            if (bucket.size() < tokenSize) {
                                // 定时放入令牌
                                bucket.put(new Token());
                            }
                        } catch (InterruptedException e) {
                            //
                        }
                    }
                }
            }, 0, 100);
        }
    }

    /**
     * 令牌
     */
    private static class Token {

    }
}
