package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class PresenceDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.PRESENCE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message presenceMessage = new Message(MessageChannel.PRESENCE.getValue(), MessageType.CRITIC.getValue());
		 publish(presenceMessage, pubSubService);
	}
}