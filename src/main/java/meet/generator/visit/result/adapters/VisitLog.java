package meet.generator.visit.result.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.ports.VisitResultBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(VisitResultBinding.class)
public class VisitLog {

    @StreamListener(VisitResultBinding.OUTCOMMING_VISITS)
    public void log(@Payload Visit visit) {
        log.info("Received visit: {}", visit);
    }
}