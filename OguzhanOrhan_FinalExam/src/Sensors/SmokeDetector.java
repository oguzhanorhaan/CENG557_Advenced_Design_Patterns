package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class SmokeDetector implements ISensor {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.SMOKE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }


    public void generateMessage(PubSubService pubSubService) {
    	//TODO: Add timer
    	Message smokeMessage = new Message(MessageChannel.SMOKE.getValue(), MessageType.CRITIC.getValue()+ " from SmokeDetector");
    	publish(smokeMessage, pubSubService);
    	
    }
}