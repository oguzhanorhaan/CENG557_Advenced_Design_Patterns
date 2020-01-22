package pubsub.subscriber;

import java.util.ArrayList;
import java.util.List;

import pubsub.Message;
import pubsub.service.PubSubService;

public abstract class AbstractSubscriber {
	//store all messages received by the subscriber
		private List<Message> subscriberMessages = new ArrayList<Message>();
		
		public List<Message> getSubscriberMessages() {
			return subscriberMessages;
		}
		public void setSubscriberMessages(List<Message> subscriberMessages) {
			this.subscriberMessages = subscriberMessages;
		}

		public void subscribeTo(String topic, PubSubService pubSubService) {
		pubSubService.addSubscriber(topic, this);
	}

		public void unSubscribe(String topic, PubSubService pubSubService) {
		pubSubService.removeSubscriber(topic, this);
	}
		
		//Request specifically for messages related to topic from PubSubService
		public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
			pubSubService.getMessagesForSubscriberOfTopic(topic, this);
		}

		public abstract void controlMessages();
		
		//Print all messages received by the subscriber 
		public void printMessages(){
			for(Message message : subscriberMessages){
				System.out.println("Message Topic -> "+ message.getTopic() + " : " + message.getPayload());
			}
		}
}
