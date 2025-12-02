package com.example.simplekafkaconsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class SimpleConsumer {

    // 토픽 이름
    private final static String TOPIC_NAME = "test";

    // 데이터를 가져올 카프카 클러스터 서버의 host와 IP를 지정한다.
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    /* 컨슈머 그룹 이름 선언
     * 컨슈머 그룹을 통해 컨슈머의 목적 구분
     * email을 발송처리하는 애플리케이션이라면 email-application-group으로 지정
     * 컨슈머 그룹을 기준으로 컨슈머 오프셋을 관리하기 때문에 subscribe() 메서드 사용시 컨슈머 그룹 선언 필요
     * 컨슈머 오프셋이 있어야 컨슈머가 도중에 중단, 재시작되더라도 오프셋 이후 데이터 처리가 가능 */
    private final static String GROUP_ID = "test-group";

    public static void main(String[] args) {
        Properties configs = new Properties();

        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);

        // 메시지 key와 value를 역직렬화하기 위한 직렬화 클래스 선언
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Properties를 KafkaConsumer 생성 파라미터로 전달하여 인스턴스 생성
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);

        // 컨슈머에게 토픽을 할당
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        /* 컨슈머는 poll() 메서드를 통해 데이터를 가져와 처리한다.
        * 지속적으로 데이터를 처리하기 위해서 반복 호출을 해야 한다. */
        while (true) {
            // poll() 메서드는 Duration 타입을 인자로 받는다.
            // 컨슈머 버퍼에 데이터를 기다리기 위한 타임아웃 간격을 뜻한다.
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                log.info("record: {}", record);
            }
        }
    }
}
