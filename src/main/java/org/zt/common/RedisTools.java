package org.zt.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisTools {

    @Autowired
    Parameters pt;

    private RedisTools(){}


    //主动付生成redis订单数据
    public String reddata(String redisorder, String key){

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(pt.getRedisip(),6379);
        jedis.auth("Jht123456");
        //月卡订单key
        String monkeys="SC_JSCSP_ORDER_ORDER_NO_"+redisorder+"_INFO";

        String ks=jedis.hkeys(key).toString();
        return ks;
    }

}

