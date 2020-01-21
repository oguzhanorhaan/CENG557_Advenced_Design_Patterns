package pubsub.publisher;

import pubsub.Message;
import pubsub.service.PubSubService;

public class Publisher implements IPublisher{
	public void publish(Message message, PubSubService pubSubService) {		
		pubSubService.addMessageToQueue(message);
	}
}
