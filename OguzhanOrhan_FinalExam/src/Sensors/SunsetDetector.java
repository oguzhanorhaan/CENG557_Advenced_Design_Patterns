package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;

public class SunsetDetector  implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}