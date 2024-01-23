package br.com.gabrieldragone;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.HashMap;

public class FraudDetectorService {

    public static void main(String[] args) {
        System.out.println("Initializing Fraud Detector...");

        var fraudDetectorService = new FraudDetectorService();
        try (var kafkaService = new KafkaConsumerMessage<>( // Independente se ocorrer erro ou se der certo, fechará a conexão com recurso na sequencia.
                FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudDetectorService::parse, // Referencia para o método parse.
                Order.class, // O tipo que estamos esperando para deserializar a mensagem
                new HashMap<>())) { // Properiedades extras se quisermos setar
            kafkaService.run();
        }
    }

    private void parse(ConsumerRecord<String, Order> record) { //
        System.out.println("Processing new order, checking for fraud...");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
        System.out.println("Timestamp: " + record.timestamp());
        System.out.println("--------------------------------------------------");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order processed");
    }

}
