package Actuators;

import pubsub.Message;
import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import pubsub.subscriber.Subscriber;
import utils.MessageChannel;
import utils.MessageType;

import java.util.List;

public class SirenController extends AbstractSubscriber {

    @Override
    public void controlMessages() {
        for (Message message : getSubscriberMessages()) {
            if (message.getPayload() == MessageType.CRITIC.getValue()) {
                //TODO Handle
            	 System.out.println(message.getTopic() + " message not critic");
                if (message.getTopic() == MessageChannel.SMOKE.getValue()) {
                    System.out.println("Yangın var :D");
                }
            }
            else {
                System.out.println(message.getTopic() + " message not critic");
            }
        }
    }
}