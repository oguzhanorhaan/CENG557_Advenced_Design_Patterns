package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class SunsetDetector  implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.LIGHT.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }
}