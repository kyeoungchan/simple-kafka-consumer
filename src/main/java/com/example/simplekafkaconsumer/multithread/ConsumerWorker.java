package com.example.simplekafkaconsumer.multithread;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Slf4j
public class ConsumerWorker implements Runnable {

    private Properties props;
    private String topic;
    private String threadName;

    //KafkaConsumer는 스레드 세이프하지 않다. ➡ 스레드별로 KafkaConsumer 인스턴스를 별개로 만들어서 운영해야 한다.
    private KafkaConsumer<String, String> consumer;

    public ConsumerWorker(Properties props, String topic, int number) {
        this.props = props;
        this.topic = topic;
        this.threadName = "consumer-thread-" + number;
    }

    @Override
    public void run() {
        consumer = new KafkaConsumer<>(props);

        // 토픽을 명시적으로 구독한다.
        consumer.subscribe(Arrays.asList(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                log.info("record: {}", record);
            }
        }
    }
}
