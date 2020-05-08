package redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by wch on 18-4-11.
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);

        System.out.println(jedis);

        Set<String> keys = jedis.keys("*");

        jedis.set("one","1");

        System.out.println(jedis.get("one"));


    }
}
