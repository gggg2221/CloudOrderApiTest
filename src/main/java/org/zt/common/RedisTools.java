package org.zt.common;


import redis.clients.jedis.Jedis;


public class RedisTools {

//    public static void main(String[] args) {
//
//        String asd=RedData("BK11903261604270915135737041308a");
//        System.out.println(asd);
//    }


    //主动付生成redis订单数据
    public static String RedData(String redisorder,String key){

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(Constants.redisIP,6379);
        jedis.auth("Jht123456");
        //月卡订单key
        String monkeys="SC_JSCSP_ORDER_ORDER_NO_"+redisorder+"_INFO";

        String ks=jedis.hkeys(key).toString();
        return ks;
    }

}

