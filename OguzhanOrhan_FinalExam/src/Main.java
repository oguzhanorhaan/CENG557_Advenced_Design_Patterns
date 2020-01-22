import Actuators.LightController;
import Actuators.PhoneCallController;
import Actuators.PushNotificationController;
import Actuators.ShutterController;
import Actuators.SirenController;
import Sensors.DoorOpenDetector;
import Sensors.GlassBreakDetector;
import Sensors.SmokeDetector;
import Sensors.SunsetDetector;
import Sensors.TemperatureDetector;
import Sensors.WaterDetector;
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
        IPublisher doorMotionDetector = new DoorOpenDetector();
        IPublisher glassBreakDetector = new GlassBreakDetector();
        IPublisher temperatureDetector = new TemperatureDetector();
        IPublisher waterDetector = new WaterDetector();
        

        AbstractSubscriber lightController = new LightController();
        AbstractSubscriber sirenController = new SirenController();
        AbstractSubscriber phoneController = new PhoneCallController();
        AbstractSubscriber notificationController = new PushNotificationController();
        AbstractSubscriber shutterController = new ShutterController();
        AbstractSubscriber temperatureController = new ShutterController();




        PubSubService pubSubService = new PubSubService();

        //Declare Messages and Publish Messages to PubSubService
        
       


        smokeDetector.generateMessage(pubSubService);
        lightDetector.generateMessage(pubSubService);
        doorMotionDetector.generateMessage(pubSubService);
        glassBreakDetector.generateMessage(pubSubService);
        temperatureDetector.generateMessage(pubSubService);
        waterDetector.generateMessage(pubSubService); 
         
         
        //Declare Subscribers (CONSTRAINTS)
        lightController.subscribeTo(MessageChannel.LIGHT.getValue(),pubSubService);
        
        sirenController.subscribeTo(MessageChannel.SMOKE.getValue(),pubSubService);
        
        phoneController.subscribeTo(MessageChannel.SMOKE.getValue(), pubSubService);
        phoneController.subscribeTo(MessageChannel.GLASS.getValue(), pubSubService);
        phoneController.subscribeTo(MessageChannel.WATER.getValue(), pubSubService);
        
        notificationController.subscribeTo(MessageChannel.TEMPERATURE.getValue(), pubSubService);
        notificationController.subscribeTo(MessageChannel.PRESENCE.getValue(), pubSubService);
        notificationController.subscribeTo(MessageChannel.SMOKE.getValue(), pubSubService);
        notificationController.subscribeTo(MessageChannel.MOTION.getValue(), pubSubService);
        
        shutterController.subscribeTo(MessageChannel.WATER.getValue(), pubSubService);
        shutterController.subscribeTo(MessageChannel.SMOKE.getValue(), pubSubService);
        
        temperatureController.subscribeTo(MessageChannel.TEMPERATURE.getValue(), pubSubService);

        
        
        
        

        //Trying unSubscribing a subscriber
        //sirenController.unSubscribe(MessageChannel.SMOKE.getValue(), pubSubService);

        //Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
        pubSubService.broadcast();

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of LightController Subscriber are: ");
        lightController.printMessages();

        System.out.println("\nMessages of NotificationController Subscriber are: ");
        notificationController.printMessages();

        //TODO: Handle in class
        lightController.controlMessages();
        sirenController.controlMessages();
    }
}
