package xyz.soulspace.cinemaline.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import xyz.soulspace.cinemaline.entity.Order;

@Slf4j
@Component
public class OrderProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendOrder(String order) {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("topic-test", order);
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(ex.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.warn(result.toString());
            }
        });

        return "Send OK";
    }
}
