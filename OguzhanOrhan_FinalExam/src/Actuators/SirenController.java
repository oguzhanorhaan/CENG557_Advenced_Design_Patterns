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
    public void setSubscriberMessages(List<Message> subscriberMessages) {
        super.setSubscriberMessages(subscriberMessages);
        for (Message message : getSubscriberMessages()) {
            System.out.println("entered");
        }
    }

    @Override
    public void subscribeTo(String topic, PubSubService pubSubService) {
        pubSubService.addSubscriber(topic, this);
    }

    @Override
    public void unSubscribe(String topic, PubSubService pubSubService) {
        pubSubService.removeSubscriber(topic, this);
    }

    @Override
    public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
        pubSubService.getMessagesForSubscriberOfTopic(topic, this);
    }

    @Override
    public void controlMessages() {
        for (Message message : getSubscriberMessages()) {
            if (message.getPayload() == MessageType.CRITIC.getValue()) {
                //TODO Handle
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