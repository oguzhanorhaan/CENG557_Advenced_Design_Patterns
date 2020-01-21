import Actuators.LightController;
import Actuators.SirenController;
import Sensors.DoorOpenDetector;
import Sensors.SmokeDetector;
import Sensors.SunsetDetector;
import pubsub.Message;
import pubsub.publisher.IPublisher;
import pubsub.service.PubSubService;
import pubsub.subscriber.AbstractSubscriber;
import utils.MessageChannel;
import utils.MessageType;

public class Main {
    public static void main(String[] args) {
        //Instantiate publishers, subscribers and PubSubService
        IPublisher lightDetector = new SunsetDetector();
        IPublisher smokeDetector = new SmokeDetector();

        AbstractSubscriber lightController = new LightController();
        AbstractSubscriber sirenController = new SirenController();


        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to PubSubService
        Message javaMsg1 = new Message(MessageChannel.SMOKE.getValue(), MessageType.CRITIC.getValue());
        Message javaMsg2 = new Message(MessageChannel.LIGHT.getValue(), MessageType.NOT_CRITIC.getValue());


        lightDetector.publish(javaMsg2, pubSubService);
        smokeDetector.publish(javaMsg1, pubSubService);
        smokeDetector.publish(javaMsg2, pubSubService); // not valid


        //Declare Subscribers
        lightController.subscribeTo(MessageChannel.LIGHT.getValue(),pubSubService);
        sirenController.subscribeTo(MessageChannel.SMOKE.getValue(),pubSubService);

        //Trying unSubscribing a subscriber
        //sirenController.unSubscribe(MessageChannel.SMOKE.getValue(), pubSubService);

        //Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
        pubSubService.broadcast();

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of LightController Subscriber are: ");
        lightController.printMessages();

        System.out.println("\nMessages of SmokeController Subscriber are: ");
        sirenController.printMessages();

        //TODO: Handle in class
        lightController.controlMessages();
        sirenController.controlMessages();
    }
}
