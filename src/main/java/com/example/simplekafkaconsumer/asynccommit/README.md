# 💻 실행 결과
```shell
# 오프셋은 기존에는 5
21:16:35.682 [main] INFO com.example.simplekafkaconsumer.asynccommit.AsyncCommitConsumer -- Commit success for offsets {test-1=OffsetAndMetadata{offset=5, leaderEpoch=8, metadata=''}, test-0=OffsetAndMetadata{offset=6, leaderEpoch=null, metadata=''}, test-2=OffsetAndMetadata{offset=2, leaderEpoch=4, metadata=''}}
21:16:36.352 [main] INFO com.example.simplekafkaconsumer.asynccommit.AsyncCommitConsumer -- record: ConsumerRecord(topic = test, partition = 1, leaderEpoch = 8, offset = 5, CreateTime = 1764850595302, deliveryCount = null, serialized key size = -1, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = testMessage for Async)

# 데이터 전송
21:16:36.369 [main] INFO com.example.simplekafkaconsumer.asynccommit.AsyncCommitConsumer -- Commit success for offsets {test-1=OffsetAndMetadata{offset=6, leaderEpoch=8, metadata=''}, test-0=OffsetAndMetadata{offset=6, leaderEpoch=null, metadata=''}, test-2=OffsetAndMetadata{offset=2, leaderEpoch=4, metadata=''}}

# 오프셋이 6으로 바뀜
21:16:37.373 [main] INFO com.example.simplekafkaconsumer.asynccommit.AsyncCommitConsumer -- Commit success for offsets {test-1=OffsetAndMetadata{offset=6, leaderEpoch=8, metadata=''}, test-0=OffsetAndMetadata{offset=6, leaderEpoch=null, metadata=''}, test-2=OffsetAndMetadata{offset=2, leaderEpoch=4, metadata=''}}
```