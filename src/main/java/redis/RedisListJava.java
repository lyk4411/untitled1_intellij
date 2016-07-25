package redis;

/**
 * Created by lyk on 2016/7/25.
 * Package name: redis
 * Porject name: untitled1
 */

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        jedis.lpush("tutorial-list", "Oracle");
        jedis.lpush("tutorial-list", "Java");


        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }
}
