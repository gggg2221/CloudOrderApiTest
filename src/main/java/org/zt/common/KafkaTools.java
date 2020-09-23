package org.zt.common;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaTools {

    @Autowired
    Parameters pt;

    private final KafkaProducer<String, String> producer;
    String ip="10.10.203.201:9092,10.10.203.202:9092,10.10.203.203:9092";
    String ycip="10.10.204.185:9092,10.10.204.186:9092,10.10.204.42:9092";

    public KafkaTools(){

        Properties props = new Properties();
        props.put("bootstrap.servers", ip);//xxx服务器ip
        props.put("acks", "all");//所有follower都响应了才认为消息提交成功，即"committed"
        props.put("retries", 0);//retries = MAX 无限重试，直到你意识到出现了问题:)
        props.put("batch.size", 16384);//producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        //batch.size当批量的数据大小达到设定值后，就会立即发送，不顾下面的linger.ms
        props.put("linger.ms", 1);//延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put("buffer.memory", 33554432);//producer可以用来缓存数据的内存大小。
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    //write data
    public void produce(String topic, String json) {

            producer.send(new ProducerRecord<String, String>(topic, json));

//        try {
//
//
//            Thread.sleep(2000);
//        }
//         catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
    //close con
    public void produceclose() {
        producer.close();

    }

}