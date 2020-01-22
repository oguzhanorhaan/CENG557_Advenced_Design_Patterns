package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class PresenceDetector implements ISensor {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.PRESENCE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message presenceMessage = new Message(MessageChannel.PRESENCE.getValue(), MessageType.CRITIC.getValue()+ " from PresenceDetector");
		 publish(presenceMessage, pubSubService);
	}
}