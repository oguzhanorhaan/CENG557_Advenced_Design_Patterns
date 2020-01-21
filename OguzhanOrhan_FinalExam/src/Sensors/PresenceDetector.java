package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.Publisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class PresenceDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.PRESENCE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }
}