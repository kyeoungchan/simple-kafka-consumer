### 💻 실행 가이드
1. `MultiWorkerThreadConsumer`를 실행한다.
2. kafka-console-producer 커맨드 보낸다.
```shell
# 로컬 환경에서 보낸다.
$ bin/kafka-console-producer.sh --bootstrap-server my-kafka:9092 \
--topic test
> hello
> kafka
> hello
> world
```

### 💻 실행 결과
```shell
08:42:04.009 [main] INFO com.example.simplekafkaconsumer.multiworker.MultiWorkerThreadConsumer -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1765496522958, deliveryCount = null, serialized key size = -1, serialized value size = 5, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = hello)
08:42:04.018 [pool-1-thread-1] INFO com.example.simplekafkaconsumer.multiworker.ConsumerWorker -- thread: pool-1-thread-1	record: hello
08:42:05.373 [main] INFO com.example.simplekafkaconsumer.multiworker.MultiWorkerThreadConsumer -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 1, CreateTime = 1765496524300, deliveryCount = null, serialized key size = -1, serialized value size = 5, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = kafka)
08:42:05.374 [pool-1-thread-1] INFO com.example.simplekafkaconsumer.multiworker.ConsumerWorker -- thread: pool-1-thread-1	record: kafka
08:42:06.521 [main] INFO com.example.simplekafkaconsumer.multiworker.MultiWorkerThreadConsumer -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 2, CreateTime = 1765496525502, deliveryCount = null, serialized key size = -1, serialized value size = 5, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = hello)
08:42:06.522 [pool-1-thread-1] INFO com.example.simplekafkaconsumer.multiworker.ConsumerWorker -- thread: pool-1-thread-1	record: hello
08:42:06.522 [main] INFO com.example.simplekafkaconsumer.multiworker.MultiWorkerThreadConsumer -- record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 3, CreateTime = 1765496526365, deliveryCount = null, serialized key size = -1, serialized value size = 5, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = world)
08:42:06.522 [pool-1-thread-1] INFO com.example.simplekafkaconsumer.multiworker.ConsumerWorker -- thread: pool-1-thread-1	record: world

```