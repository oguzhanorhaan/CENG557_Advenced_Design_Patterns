package Actuators;

import pubsub.Message;
import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import utils.MessageType;

public class TemperatureController extends AbstractSubscriber {
    
    @Override
    public void controlMessages() {
        for (Message message : getSubscriberMessages()) {
            if (message.getPayload() == MessageType.CRITIC.getValue()) {
                //TODO Handle
            }
            else {
                System.out.println(message.getTopic() + " message not critic");
            }
        }
    }
}