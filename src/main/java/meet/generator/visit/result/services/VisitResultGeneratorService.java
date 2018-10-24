package meet.generator.visit.result.services;

import meet.generator.visit.result.model.Disease;
import meet.generator.visit.result.model.Drug;
import meet.generator.visit.result.model.Visit;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class VisitResultGeneratorService {

    private final double[] drugWeights = {0.05, 0.2, 0.05, 0.05, 0.05, 0.05, 0.05, 0.0, 0.0, 0.0};
    private final double[] diseaseWeights = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.1, 0.2, 0.1, 0.1, 0.1, 0.2, 0.2};

    private Random randomCost = new Random();

    public Visit generateVisitResult(Visit visit) {
        visit.setDiagnosedDisease(random(diseaseWeights, Disease.class));
        visit.setPrescribedDrugs(List.of(random(drugWeights, Drug.class)));
        visit.setAppointmentTime(System.currentTimeMillis());
        visit.setClinicCost(generateFromRange(10.0, 200));
        visit.setClinicIncome(generateFromRange(100.0, 200));
        return visit;
    }

    private double generateFromRange(double init, int max) {
        double value = init + randomCost.nextDouble() * 10 * max;
        return Precision.round(value, 2);
    }

    public static <E extends Enum<E>> E random(double[] weights, Class<E> enumData) {
        Random rand = new Random();
        double p = rand.nextDouble();
        double sum = 0.0;
        int i = 0;
        while ((sum < p) && (i < weights.length)) {
            sum += weights[i];
            i++;
        }
        return Arrays.asList(enumData.getEnumConstants()).get(i - 1);
    }
}
