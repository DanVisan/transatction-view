package ro.vis.transactionview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import ro.vis.transactionview.models.Transaction;
import ro.vis.transactionview.services.TransactionService;

import java.util.Objects;

@EnableBinding(KafkaChannels.class)
public class KafkaReceiver {
    private final TransactionService transactionService;

    @Autowired
    public KafkaReceiver(TransactionService transactionService) {
        this.transactionService = Objects.requireNonNull(transactionService, "transactionService must not be null!");
    }

    @StreamListener(KafkaChannels.EVENTS_INPUT)
    public void receiveEvents(final Transaction transaction) {
        transactionService.intercept(transaction);
    }
}
