package rateLimit;


public abstract class AbstractLimiter {

    /**
     * 最大流量
     */
    protected final int MAX_FlOW;

    /**
     * 构造器 , 输入每秒最大流量
     * @param MAX_FlOW 最大流量
     */
    public AbstractLimiter(int MAX_FlOW) {
        this.MAX_FlOW = MAX_FlOW;
    }


    /**
     * 具体实现的方法
     * @param request 请求
     * @param response 响应
     * @param chain 执行
     */
    public abstract void limit(ServletRequest request, ServletResponse response, FilterChain chain);

}
