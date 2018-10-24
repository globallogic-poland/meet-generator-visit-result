package meet.generator.visit.result.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface VisitResultBinding {

    String VISITS_BEFORE_APPOINTMENT = "visits-before-appointment";
    String VISITS_AFTER_APPOINTMENT = "visits-after-appointment";

    String VISITS_DISPATCHER_INPUT = "visits-dispatcher-input";
    String VISITS_DISPATCHER_OUTPUT = "visits-dispatcher-output";

    @Input(VISITS_BEFORE_APPOINTMENT)
    MessageChannel visitsBeforeAppontment();

    @Output(VISITS_AFTER_APPOINTMENT)
    MessageChannel visitsAfterAppontment();

    @Input(VISITS_DISPATCHER_INPUT)
    SubscribableChannel visitsDispatcherInput();

    @Output(VISITS_DISPATCHER_OUTPUT)
    MessageChannel visitsDispatcherOutput();

}