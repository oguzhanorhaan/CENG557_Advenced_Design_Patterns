package Devices;

import Actuators.AbstractPubSubController;
import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class Siren extends AbstractDevice {

    @Override
    public void controlMessages(PubSubService service) {
        for (Message message: getSubscriberMessages()) {
            if (message.getTopic() == MessageChannel.SMOKE.getValue()) {
                System.out.println("SMOKE LEVEL IS "+message.getPayload()+", SIREN IS ACTIVE");
            }
            else if (message.getTopic() == MessageChannel.WATER.getValue()) {
                System.out.println("WATER IN HOUSE IS "+message.getPayload()+", SIREN IS ACTIVE");
            }
        }
    }
}
