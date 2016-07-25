package redis;

import redis.clients.jedis.Jedis;

/**
 * Created by lyk on 2016/7/25.
 * Package name: redis
 * Porject name: untitled1
 */


public class Infrastructure {
    static String constr = "127.0.0.1" ;
    public static Jedis getRedis(){
        Jedis jedis = new Jedis(constr) ;
        return jedis ;
    }
    public static void main(String[] args){
        Jedis j = Infrastructure. getRedis() ;
        String output ;
        j.set( "hello", "world" ) ;
        output = j.get( "hello") ;
        System.out.println(output) ;
    }
}