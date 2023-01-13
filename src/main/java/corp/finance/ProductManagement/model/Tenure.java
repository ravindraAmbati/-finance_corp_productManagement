package corp.finance.ProductManagement.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Tenure {

    private String tenureId;
    private String tenureName;
    private Period tenurePeriod;
    private LocalDate tenureStartDate;
    private LocalDate tenureEndDate;
    private Period tenureInterval;
    private Audit audit;

    public Period getTenurePeriod() {
        return Period.between(this.getTenureStartDate(), this.getTenureEndDate());
    }
}
