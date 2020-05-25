package redis;

import redis.clients.jedis.Jedis;

/**
 * Created by tangwc on 2020/5/9.
 */
public class JedisMonitor {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.monitor(new redis.clients.jedis.JedisMonitor() {
            @Override
            public void onCommand(String s) {
                System.out.println(s);
            }
        });

    }
}
