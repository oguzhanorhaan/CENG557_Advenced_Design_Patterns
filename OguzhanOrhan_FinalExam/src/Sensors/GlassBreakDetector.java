package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.Publisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class GlassBreakDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.GLASS.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }
}