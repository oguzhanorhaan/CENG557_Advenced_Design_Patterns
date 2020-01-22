package Actuators;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageType;

public class AbstractBaseController extends AbstractPubSubController{
    @Override
    public void controlMessages(PubSubService service) {
        for (Message message : getSubscriberMessages()) {
            if (message.getPayload().contains(MessageType.CRITIC.getValue()) ) {
                publish(message, service);
            }
            else {
                System.out.println(message.getTopic() + " message not critic");
            }
        }
    }
}
