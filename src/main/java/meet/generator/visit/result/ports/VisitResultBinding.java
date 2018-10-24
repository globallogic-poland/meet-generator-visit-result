package meet.generator.visit.result.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VisitResultBinding {

    String VISITS_BEFORE_APPOINTMENT = "visits-before-appointment";
    String VISITS_AFTER_APPOINTMENT = "visits-after-appointment";

    @Input(VISITS_BEFORE_APPOINTMENT)
    MessageChannel visitsBeforeAppontment();

    @Output(VISITS_AFTER_APPOINTMENT)
    MessageChannel visitsAfterAppontment();
}