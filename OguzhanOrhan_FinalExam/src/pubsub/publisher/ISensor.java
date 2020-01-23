package pubsub.publisher;

import pubsub.service.PubSubService;

public interface ISensor extends IPublisher {
    void generateMessage(PubSubService pubSubService);
}
