package Actuators;

import pubsub.Message;
import pubsub.publisher.IAlertController;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import utils.MessageType;

import java.util.List;

public abstract class AbstractPubSubController extends AbstractSubscriber implements IAlertController {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}
