package Devices;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class Light extends AbstractDevice {

    @Override
    public void controlMessages(PubSubService service) {
        for (Message message: getSubscriberMessages()) {
            if (message.getTopic() == MessageChannel.PRESENCE.getValue()) {
               System.out.println("DEVICE => LIGHT --> Channel PRESENCE -There is someone in the house, message from PRESENCE Detector, opening lights");

            }
            else if (message.getTopic() == MessageChannel.LIGHT.getValue()) {
                System.out.println("DEVICE => LIGHT --> Channel LIGHT - Open signal received from sunsetDetector, opening lights");
            }
        }
    }
}
