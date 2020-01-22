package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class TemperatureDetector implements ISensor {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.TEMPERATURE.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message temperatureMessage = new Message(MessageChannel.TEMPERATURE.getValue(), MessageType.CRITIC.getValue()+ " from TemperatureDetector");
		 publish(temperatureMessage, pubSubService);		
	}
}
