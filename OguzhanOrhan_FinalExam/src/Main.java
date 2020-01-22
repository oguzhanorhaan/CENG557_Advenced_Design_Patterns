import Actuators.*;
import Devices.*;
import Sensors.DoorOpenDetector;
import Sensors.GlassBreakDetector;
import Sensors.SmokeDetector;
import Sensors.SunsetDetector;
import Sensors.TemperatureDetector;
import Sensors.WaterDetector;
import pubsub.publisher.ISensor;
import pubsub.service.PubSubService;
import utils.MessageChannel;

public class Main {
    public static void main(String[] args) {
        //Instantiate publishers, subscribers and PubSubService
        ISensor lightDetector = new SunsetDetector();
        ISensor smokeDetector = new SmokeDetector();
        ISensor doorMotionDetector = new DoorOpenDetector();
        ISensor glassBreakDetector = new GlassBreakDetector();
        ISensor temperatureDetector = new TemperatureDetector();
        ISensor waterDetector = new WaterDetector();
        

        AbstractBaseController lightController = new LightControllerAbstract();
        AbstractBaseController sirenController = new SirenControllerAbstract();
        AbstractBaseController phoneController = new PhoneCallControllerAbstract();
        AbstractBaseController notificationController = new PushNotificationControllerAbstract();
        AbstractBaseController shutterController = new ShutterControllerAbstract();
        AbstractBaseController temperatureController = new ShutterControllerAbstract();


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
        sirenController.subscribeTo(MessageChannel.WATER.getValue(), pubSubService);

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
        System.out.println("Messages of LightController  are: ");
        lightController.printMessages();

        System.out.println("\nMessages of NotificationController  are: ");
        notificationController.printMessages();

        System.out.println("\nMessages of sirenController  are: ");
        sirenController.printMessages();

        System.out.println("\nMessages of phoneController  are: ");
        phoneController.printMessages();

        System.out.println("\nMessages of shutterController  are: ");
        shutterController.printMessages();

        System.out.println("\nMessages of temperatureController  are: ");
        temperatureController.printMessages();


        lightController.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        sirenController.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        phoneController.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        notificationController.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        shutterController.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        temperatureController.controlMessages(pubSubService);
        System.out.println("---------------------------------");






        //Init & Subscribe Devices to Controllers
        AbstractDevice light = new Light();
        AbstractDevice mobilePhone = new MobilePhone();
        AbstractDevice siren = new Siren();
        AbstractDevice wallPanel = new WallPanel();

        light.subscribeTo(MessageChannel.PRESENCE.getValue(),pubSubService);
        light.subscribeTo(MessageChannel.LIGHT.getValue(),pubSubService);

        mobilePhone.subscribeTo(MessageChannel.SMOKE.getValue(), pubSubService);
        mobilePhone.subscribeTo(MessageChannel.GLASS.getValue(), pubSubService);
        mobilePhone.subscribeTo(MessageChannel.WATER.getValue(), pubSubService);
        mobilePhone.subscribeTo(MessageChannel.MOTION.getValue(), pubSubService);

        siren.subscribeTo(MessageChannel.SMOKE.getValue(), pubSubService);
        siren.subscribeTo(MessageChannel.WATER.getValue(), pubSubService);

        wallPanel.subscribeTo(MessageChannel.PRESENCE.getValue(), pubSubService);


        pubSubService.broadcast();


        light.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        mobilePhone.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        siren.controlMessages(pubSubService);
        System.out.println("---------------------------------");

        wallPanel.controlMessages(pubSubService);
        System.out.println("---------------------------------");
    }
}
