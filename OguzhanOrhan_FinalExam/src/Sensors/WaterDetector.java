package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.Publisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class WaterDetector  implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.WATER.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }
}
