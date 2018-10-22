package meet.generator.visit.result.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface VisitResultBinding {

    String VISITS_BEFORE_APPOINTMANT = "visits-before-appointmant";
    String VISITS_AFTER_APPOINTMANT = "visits-after-appointmant";
    String OUTCOMMING_VISITS = "outcomming-visits";

    @Input(VISITS_BEFORE_APPOINTMANT)
    MessageChannel visitsBeforeAppontmant();

    @Output(VISITS_AFTER_APPOINTMANT)
    MessageChannel visitsAfterAppontmant();

    @Input(OUTCOMMING_VISITS)
    SubscribableChannel outcommingVisits();
}