### 💻 실행 가이드
1. `MultiConsumerThread`를 실행한다.
2. kafka-console-producer 커맨드 보낸다.

```shell
# 로컬 환경에서 보낸다.
$ bin/kafka-console-producer.sh --bootstrap-server my-kafka:9092 \
--topic test
> 1
> 2
> 3
```

### 💻 실행 결과
```shell
19:47:31.077 [pool-1-thread-3] INFO com.example.simplekafkaconsumer.multithread.ConsumerWorker -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 4, CreateTime = 1765536449989, deliveryCount = null, serialized key size = -1, serialized value size = 1, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = 1)
19:47:31.081 [pool-1-thread-3] INFO com.example.simplekafkaconsumer.multithread.ConsumerWorker -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 5, CreateTime = 1765536450455, deliveryCount = null, serialized key size = -1, serialized value size = 1, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = 2)
19:47:32.041 [pool-1-thread-3] INFO com.example.simplekafkaconsumer.multithread.ConsumerWorker -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 6, CreateTime = 1765536451020, deliveryCount = null, serialized key size = -1, serialized value size = 1, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = 3)
```