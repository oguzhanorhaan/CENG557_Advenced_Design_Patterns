package Actuators;

import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import pubsub.subscriber.Subscriber;

public abstract class PhoneCallController extends AbstractSubscriber {

	@Override
	public void subscribeTo(String topic, PubSubService pubSubService) {
		pubSubService.addSubscriber(topic, this);
	}

	@Override
	public void unSubscribe(String topic, PubSubService pubSubService) {
		pubSubService.removeSubscriber(topic, this);
	}

	@Override
	public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
		pubSubService.getMessagesForSubscriberOfTopic(topic, this);
	}
}