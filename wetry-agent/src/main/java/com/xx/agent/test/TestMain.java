package com.xx.agent.test;

/**
 * @Author: tangwenchuan
 * @Date: 2021/4/29 3:37 下午
 */
public class TestMain {

    /**
     * 这个方法会被注入agent，统计耗时
     * @param args
     */
    public static void main(String[] args) {
        DemoClz demoClz = new DemoClz();
        int cnt = 0;
        for (int i = 0; i < 20; i++) {
            if (++cnt % 2 == 0) {
                i = demoClz.print(i);
            } else {
                i = demoClz.count(i);
            }
        }
    }
}
