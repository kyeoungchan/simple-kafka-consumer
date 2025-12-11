package com.example.simplekafkaconsumer.multiworker;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 데이터를 처리하는 스레드를 개별로 생성하기 위해 데이터를 처리하는 사용자 지정 스레드를 새로 생성
 */
@Slf4j
@AllArgsConstructor
public class ConsumerWorker implements Runnable {

    private String recordValue;

    @Override
    public void run() {
        log.info("thread: {}\trecord: {}", Thread.currentThread().getName(), recordValue);
    }
}
