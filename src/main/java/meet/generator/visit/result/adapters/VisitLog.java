package meet.generator.visit.result.adapters;

import lombok.extern.slf4j.Slf4j;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.ports.VisitBindings;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(VisitBindings.class)
public class VisitLog {

    @StreamListener(VisitBindings.INPUT)
    public void log(@Payload Visit visit) {
        log.info("Received visit: {}", visit);
    }
}