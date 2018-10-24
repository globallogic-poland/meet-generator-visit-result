package meet.generator.visit.result.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@Value
@Builder
public class Doctor {

    String id;

    String firstName;

    String lastName;

    String district;

    String city;

    String country;

    @Singular
    Set<Specialization> specializations;

}
