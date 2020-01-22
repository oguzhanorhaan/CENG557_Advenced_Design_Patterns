package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class TemperatureDetector implements IPublisher {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.TEMPERATURE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message temperatureMessage = new Message(MessageChannel.TEMPERATURE.getValue(), MessageType.CRITIC.getValue());
		 publish(temperatureMessage, pubSubService);		
	}
}
