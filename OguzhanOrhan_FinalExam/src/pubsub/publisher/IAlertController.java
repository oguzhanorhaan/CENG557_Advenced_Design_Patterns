package pubsub.publisher;

import pubsub.Message;
import pubsub.service.PubSubService;
import utils.MessageType;

import java.util.List;

public interface IAlertController extends IPublisher {
    void controlMessages(PubSubService service);
}
