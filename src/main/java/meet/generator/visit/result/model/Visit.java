package meet.generator.visit.result.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@Setter
public class Visit {

    private String id;

    private Doctor doctor;

    private Patient patient;

    private Clinic clinic;

    private Disease diagnosedDisease;

    @Singular
    private List<Drug> prescribedDrugs;

    private double clinicCost;

    private double clinicIncome;

    private long appointmentTime;

}
