package redis;

import redis.clients.jedis.Jedis;

/**
 * Created by lyk on 2016/7/25.
 * Package name: redis
 * Porject name: untitled1
 */
public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
