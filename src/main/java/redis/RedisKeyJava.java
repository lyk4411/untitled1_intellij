package redis;

/**
 * Created by lyk on 2016/7/25.
 * Package name: redis
 * Porject name: untitled1
 */

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisKeyJava {
    private static Set<String> hashSet;

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        // 获取数据并输出
        RedisKeyJava.hashSet =  jedis.keys("*");
        for(int i=0; i<hashSet.size(); i++) {
            System.out.println("List of stored keys:: "+hashSet.toString());
        }
    }
}