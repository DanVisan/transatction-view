package ro.vis.transactionview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import ro.vis.transactionview.models.TransactionModel;
import ro.vis.transactionview.services.BalanceService;

import java.util.Objects;

@EnableBinding(KafkaChannels.class)
public class KafkaReceiver {
    private final BalanceService balanceService;

    @Autowired
    public KafkaReceiver(BalanceService balanceService) {
        this.balanceService = Objects.requireNonNull(balanceService, "transactionService must not be null!");
    }

    @StreamListener(KafkaChannels.EVENTS_INPUT)
    public void receiveEvents(final TransactionModel transaction) {
        balanceService.updateBalance(transaction);
    }
}
