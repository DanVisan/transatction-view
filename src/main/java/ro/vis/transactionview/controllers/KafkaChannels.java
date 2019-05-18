package ro.vis.transactionview.controllers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {
    String EVENTS_INPUT = "events";

    @Input(KafkaChannels.EVENTS_INPUT)
    MessageChannel eventInput();
}
