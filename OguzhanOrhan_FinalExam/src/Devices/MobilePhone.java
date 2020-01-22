package Devices;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class MobilePhone extends AbstractDevice {

    @Override
    public void controlMessages(PubSubService service) {
        for (Message message: getSubscriberMessages()) {
            if (message.getTopic() == MessageChannel.SMOKE.getValue()) {
                System.out.println("DEVICE => MobilePhone --> Channel SMOKE level is "+message.getPayload()+ " calling the fire station"); //payload can be customized
                System.out.println("DEVICE => MobilePhone --> Channel SMOKE level is "+message.getPayload()+ " calling the  user"); //payload can be customized
                System.out.println("DEVICE => MobilePhone --> Channel SMOKE level is "+message.getPayload()+ " sending Notification to user"); //payload can be customized
            }
            else if (message.getTopic() == MessageChannel.GLASS.getValue()) {
                System.out.println("DEVICE => MobilePhone --> Channel GLASS is broken message from GlassBreakDetector,  calling the Police station"); //payload can be customized
                System.out.println("DEVICE => MobilePhone --> Channel GLASS is broken from GlassBreakDetector, sending Notification to user"); //payload can be customized
            }
            else if (message.getTopic() == MessageChannel.WATER.getValue()) {
                System.out.println("DEVICE => MobilePhone --> Channel WATER level is "+message.getPayload()+ " calling the user"); //payload can be customized
            }
            else if (message.getTopic() == MessageChannel.MOTION.getValue()) {
                System.out.println("DEVICE => MobilePhone --> Channel There is a motion message from MOTION Sensor, sending Notification to user"); //payload can be customized
            }

        }
    }
}
