package meet.generator.visit.result.adapters;


import meet.generator.visit.result.model.Drug;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.ports.VisitResultBinding;
import meet.generator.visit.result.services.VisitResultGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;

import static meet.generator.visit.result.ports.VisitResultBinding.VISITS_AFTER_APPOINTMANT;
import static meet.generator.visit.result.ports.VisitResultBinding.VISITS_BEFORE_APPOINTMANT;
import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

@EnableBinding(VisitResultBinding.class)
public class VisitResultGenerator {

    private VisitResultGeneratorService visitResultGeneratorService;

    public VisitResultGenerator(VisitResultGeneratorService visitResultGeneratorService) {
        this.visitResultGeneratorService = visitResultGeneratorService;
    }

    @StreamListener
    @Output(VISITS_AFTER_APPOINTMANT)
    public Flux<Visit> generateVisitResult(@Input(VISITS_BEFORE_APPOINTMANT) Flux<Visit> inbound) {
        return inbound.
                log()
                .map(visitResultGeneratorService::generate)
                .log();
    }

}
