package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class WaterDetector  implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.WATER.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message waterMessage = new Message(MessageChannel.WATER.getValue(), MessageType.NOT_CRITIC.getValue());
		 publish(waterMessage, pubSubService);	
	}
}
