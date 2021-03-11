package rateLimit;

public interface FilterChain {

    void doFilter(ServletRequest request, ServletResponse response);
}
