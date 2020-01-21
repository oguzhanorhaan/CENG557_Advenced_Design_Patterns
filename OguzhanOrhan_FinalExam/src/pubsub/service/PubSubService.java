package pubsub.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import pubsub.Message;
import pubsub.subscriber.AbstractSubscriber;

public class PubSubService {
	//Keeps set of subscriber topic wise, using set to prevent duplicates 
		Map<String, Set<AbstractSubscriber>> subscribersTopicMap = new HashMap<String, Set<AbstractSubscriber>>();

		//Holds messages published by publishers
		Queue<Message> messagesQueue = new LinkedList<Message>();

		//Adds message sent by publisher to queue
		public void addMessageToQueue(Message message){
			messagesQueue.add(message);
		}

		//Add a new Subscriber for a topic
		public void addSubscriber(String topic, AbstractSubscriber subscriber){

			if(subscribersTopicMap.containsKey(topic)){
				Set<AbstractSubscriber> subscribers = subscribersTopicMap.get(topic);
				subscribers.add(subscriber);
				subscribersTopicMap.put(topic, subscribers);
			}else{
				Set<AbstractSubscriber> subscribers = new HashSet<AbstractSubscriber>();
				subscribers.add(subscriber);
				subscribersTopicMap.put(topic, subscribers);
			}		
		}

		//Remove an existing subscriber for a topic
		public void removeSubscriber(String topic, AbstractSubscriber subscriber){

			if(subscribersTopicMap.containsKey(topic)){
				Set<AbstractSubscriber> subscribers = subscribersTopicMap.get(topic);
				subscribers.remove(subscriber);
				subscribersTopicMap.put(topic, subscribers);
			}
		}

		//Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
		public void broadcast(){
			if(messagesQueue.isEmpty()){
				System.out.println("No messages from publishers to display");
			}else{
				while(!messagesQueue.isEmpty()){
					Message message = messagesQueue.remove();
					String topic = message.getTopic();

					Set<AbstractSubscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

					for(AbstractSubscriber subscriber : subscribersOfTopic){
						//add broadcasted message to subscribers message queue
						List<Message> subscriberMessages = subscriber.getSubscriberMessages();
						subscriberMessages.add(message);
						subscriber.setSubscriberMessages(subscriberMessages);
					}			
				}
			}
		}

		//Sends messages about a topic for subscriber at any point
		public void getMessagesForSubscriberOfTopic(String topic, AbstractSubscriber subscriber) {
			if(messagesQueue.isEmpty()){
				System.out.println("No messages from publishers to display");
			}else{
				while(!messagesQueue.isEmpty()){
					Message message = messagesQueue.remove();

					if(message.getTopic().equalsIgnoreCase(topic)){

						Set<AbstractSubscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

						for(AbstractSubscriber _subscriber : subscribersOfTopic){
							if(_subscriber.equals(subscriber)){
								//add broadcasted message to subscriber message queue
								List<Message> subscriberMessages = subscriber.getSubscriberMessages();
								subscriberMessages.add(message);
								subscriber.setSubscriberMessages(subscriberMessages);
							}
						}
					}
				}
			}
		}
}
