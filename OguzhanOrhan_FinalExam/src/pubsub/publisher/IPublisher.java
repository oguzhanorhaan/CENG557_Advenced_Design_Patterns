package pubsub.publisher;

import pubsub.Message;
import pubsub.service.PubSubService;

public interface IPublisher {
	void publish(Message message, PubSubService pubSubService);

	void generateMessage(PubSubService pubSubService);
}
