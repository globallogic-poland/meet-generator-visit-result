package meet.generator.visit.result.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
