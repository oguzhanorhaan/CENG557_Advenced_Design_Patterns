package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class GlassBreakDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.GLASS.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message glassBreak = new Message(MessageChannel.GLASS.getValue(), MessageType.CRITIC.getValue());
		 publish(glassBreak, pubSubService);		
	}
}