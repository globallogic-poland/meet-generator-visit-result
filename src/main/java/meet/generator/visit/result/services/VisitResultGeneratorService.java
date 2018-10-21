package meet.generator.visit.result.services;

import meet.generator.visit.result.model.Disease;
import meet.generator.visit.result.model.Drug;
import meet.generator.visit.result.model.Visit;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class VisitResultGeneratorService {

    private final double[]  drugWeights  = {0.05,0.2,0.05,0.05,0.05,0.05,0.05,0.0,0.0,0.0};
    private final double[]  diseaseWeights  = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.1,0.2,0.1,0.1,0.1,0.2,0.2};

    public Visit generate(Visit visit) {

        return Visit.builder()
                .id(visit.getId())
                .doctorId(visit.getDoctorId())
                .clinicId(visit.getClinicId())
                .patientId(visit.getPatientId())
                .diagnosedDisease(random(diseaseWeights, Disease.class))
                .prescribedDrug(random(drugWeights, Drug.class))
                .build();
    }

    public static <E extends Enum<E>> E random(double[] weights, Class<E> enumData){
        Random rand = new Random();
        double p = rand.nextDouble();
        double sum = 0.0;
        int i = 0;
        while((sum < p) && (i < weights.length)) {
            sum += weights[i];
            i++;
        }
        return Arrays.asList(enumData.getEnumConstants()).get(i-1);
    }
}
