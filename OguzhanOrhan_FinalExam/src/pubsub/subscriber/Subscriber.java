package pubsub.subscriber;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageType;

public class Subscriber extends AbstractSubscriber {
	//Add subscriber with PubSubService for a topic
	
		public void subscribeTo(String topic, PubSubService pubSubService){
			pubSubService.addSubscriber(topic, this);
		}
		
		//Unsubscribe subscriber with PubSubService for a topic
		public void unSubscribe(String topic, PubSubService pubSubService){
			pubSubService.removeSubscriber(topic, this);
		}

		//Request specifically for messages related to topic from PubSubService
		public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
			pubSubService.getMessagesForSubscriberOfTopic(topic, this);
			
		}
}
