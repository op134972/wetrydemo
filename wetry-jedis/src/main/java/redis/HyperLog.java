package redis;

import redis.clients.jedis.Jedis;

/**
 * @Author: tangwenchuan
 * @Date: 2019-10-17 11:02
 */
public class HyperLog {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);


        System.out.println(jedis);

        System.out.println(jedis.keys("*"));

        System.out.println(jedis.set("abc", "1"));
        System.out.println(jedis.get("abc"));

    }
}
