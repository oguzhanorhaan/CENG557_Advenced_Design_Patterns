package Sensors;

import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;
import utils.MessageType;

public class SunsetDetector  implements ISensor {

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        if (message.getTopic() == MessageChannel.LIGHT.getValue()) {
            pubSubService.addMessageToQueue(message);
        }
    }

	@Override
	public void generateMessage(PubSubService pubSubService) {
		 Message lightMessage = new Message(MessageChannel.LIGHT.getValue(), MessageType.CRITIC.getValue()+ " from SunsetDetector");
		 publish(lightMessage, pubSubService);		
	}
}