package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class DoorOpenDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.MOTION.getValue() || message.getTopic() == MessageChannel.PRESENCE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message doorMessage = new Message(MessageChannel.MOTION.getValue(), MessageType.NOT_CRITIC.getValue());
		 publish(doorMessage, pubSubService);		
		 
		 Message presenceMessage = new Message(MessageChannel.PRESENCE.getValue(), MessageType.NOT_CRITIC.getValue());
		 publish(presenceMessage, pubSubService);		
		
		
	}
}
