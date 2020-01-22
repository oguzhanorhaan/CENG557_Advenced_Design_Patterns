package Actuators;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageType;

public class LightController extends AbstractBaseController {

    //When light can be opened or closed
        @Override
        public void controlMessages(PubSubService service) {
            for (Message message : getSubscriberMessages()) {
                    publish(message, service);
            }
        }
}