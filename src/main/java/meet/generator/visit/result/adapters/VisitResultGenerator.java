package meet.generator.visit.result.adapters;


import meet.generator.visit.result.model.Drug;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.services.VisitResultGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;

@EnableBinding(Processor.class)
public class VisitResultGenerator {

    private VisitResultGeneratorService visitResultGeneratorService;

    public VisitResultGenerator(VisitResultGeneratorService visitResultGeneratorService) {
        this.visitResultGeneratorService = visitResultGeneratorService;
    }

    @StreamListener
    @Output(Processor.OUTPUT)
    public Flux<Visit> generateVisitResult(@Input(Processor.INPUT) Flux<Visit> inbound) {
        return inbound.
                log()
                .map(visitResultGeneratorService::generate)
                .log();
    }

}
