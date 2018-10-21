package meet.generator.visit.result.adapters;


import meet.generator.visit.result.model.Drug;
import meet.generator.visit.result.model.Visit;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;

@EnableBinding(Processor.class)
public class VisitResultGenerator {

    @StreamListener
    @Output(Processor.OUTPUT)
    public Flux<Visit> generateVisitResult(@Input(Processor.INPUT) Flux<Visit> inbound) {
        return inbound.
                log()
                .map(visit -> Visit.builder()
                        .id(visit.getId())
                        .diagnosedDisease(visit.getDiagnosedDisease())
                        .prescribedDrug(Drug.ABILIFY)
                        .doctorId("docId")
                        .build()
                )
                .log();
    }

}
