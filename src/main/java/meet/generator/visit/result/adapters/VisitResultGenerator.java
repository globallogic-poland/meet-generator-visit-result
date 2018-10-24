package meet.generator.visit.result.adapters;


import lombok.AllArgsConstructor;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.ports.VisitResultBinding;
import meet.generator.visit.result.services.VisitResultGeneratorService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;

import static meet.generator.visit.result.ports.VisitResultBinding.VISITS_AFTER_APPOINTMENT;
import static meet.generator.visit.result.ports.VisitResultBinding.VISITS_BEFORE_APPOINTMENT;

@AllArgsConstructor
@EnableBinding(VisitResultBinding.class)
public class VisitResultGenerator {

    private final VisitResultGeneratorService visitResultGeneratorService;

    @StreamListener
    @Output(VISITS_AFTER_APPOINTMENT)
    public Flux<Visit> generateVisitResult(@Input(VISITS_BEFORE_APPOINTMENT) Flux<Visit> inbound) {
        return inbound
                .map(visitResultGeneratorService::generateVisitResult);
    }

}
