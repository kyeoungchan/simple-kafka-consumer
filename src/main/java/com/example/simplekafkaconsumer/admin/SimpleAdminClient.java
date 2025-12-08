package com.example.simplekafkaconsumer.admin;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;

@Slf4j
public class SimpleAdminClient {

    // 데이터를 가져올 카프카 클러스터 서버의 host와 IP를 지정한다.
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties configs = new Properties();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        AdminClient admin = AdminClient.create(configs);

        // 브로커 정보 조회
        log.info("=== Get broker information");
        for (Node node : admin.describeCluster().nodes().get()) {
            log.info("node: {}", node);
            ConfigResource cr = new ConfigResource(ConfigResource.Type.BROKER, node.idString());
            DescribeConfigsResult describeConfigs = admin.describeConfigs(Collections.singleton(cr));
            describeConfigs.all().get().forEach((broker, config) -> {
                config.entries().forEach(configEntry -> log.info("{} = {}", configEntry.name(), configEntry.value()));
            });
        }

/*
        log.info("=== Get Topic information");
        KafkaFuture<TopicDescription> topicInformation = admin.describeTopics(Collections.singletonList("test")).topicIdValues().get("찾고자하는 키");
        log.info("topic information: {}", topicInformation);
*/

        admin.close();
    }
}
