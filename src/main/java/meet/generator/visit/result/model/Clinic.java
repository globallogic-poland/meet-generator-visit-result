package meet.generator.visit.result.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@Value
@Builder
public class Clinic {

    String id;
    
    String name;

    String district;

    String city;

    String country;

}
