package Devices;

import Actuators.AbstractBaseController;
import pubsub.Message;
import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import utils.MessageChannel;

public class WallPanel extends AbstractDevice {

    @Override
    public void controlMessages(PubSubService service) {
        for (Message message: getSubscriberMessages()) {
            if (message.getTopic() == MessageChannel.TEMPERATURE.getValue()) {
                System.out.println(" DEVICE => WallPanel --> Channel TEMPERATURE level is "+message.getPayload()); //payload can be customized
            }
        }
    }
}