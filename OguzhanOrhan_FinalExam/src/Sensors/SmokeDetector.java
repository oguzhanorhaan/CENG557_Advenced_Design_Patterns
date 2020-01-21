package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.Publisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class SmokeDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.SMOKE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

    //TODO: Generate messages method should be added
}