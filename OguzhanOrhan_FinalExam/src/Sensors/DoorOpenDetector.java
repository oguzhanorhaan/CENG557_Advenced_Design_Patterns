package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class DoorOpenDetector implements ISensor {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.MOTION.getValue() || message.getTopic() == MessageChannel.PRESENCE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message doorMessage = new Message(MessageChannel.MOTION.getValue(), MessageType.CRITIC.getValue() + " from DoorOpenDetector");
		 publish(doorMessage, pubSubService);		
		 
		 Message presenceMessage = new Message(MessageChannel.PRESENCE.getValue(), MessageType.CRITIC.getValue()+ " from DoorOpenDetector");
		 publish(presenceMessage, pubSubService);
	}
}
