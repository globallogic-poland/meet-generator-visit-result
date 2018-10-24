package meet.generator.visit.result.adapters;


import lombok.AllArgsConstructor;
import meet.generator.visit.result.model.Visit;
import meet.generator.visit.result.ports.VisitResultBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@AllArgsConstructor
@EnableBinding(VisitResultBinding.class)
public class VisitResultKafkaStreamsDispatcher {

    private final VisitResultBinding binding;

    @StreamListener(VisitResultBinding.VISITS_DISPATCHER_INPUT)
    public void dispatch(@Payload Visit visit) {
        log.debug("Dispatching visit: {}", visit);

        Message<Visit> message = MessageBuilder
                .withPayload(visit)
                .setHeader(KafkaHeaders.MESSAGE_KEY, null) // TODO: change that
                .build();

        binding.visitsDispatcherOutput().send(message);
    }
}
