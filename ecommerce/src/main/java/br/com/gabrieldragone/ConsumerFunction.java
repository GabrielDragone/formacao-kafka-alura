package br.com.gabrieldragone;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction {
    void consume(ConsumerRecord<String, String> record);
}
