package org.zt.common;


import redis.clients.jedis.Jedis;


public class RedisTools {

    private RedisTools(){}


    //主动付生成redis订单数据
    public static String reddata(String redisorder, String key){

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(Constants.REDISIP,6379);
        jedis.auth("Jht123456");
        //月卡订单key
        String monkeys="SC_JSCSP_ORDER_ORDER_NO_"+redisorder+"_INFO";

        String ks=jedis.hkeys(key).toString();
        return ks;
    }

}

