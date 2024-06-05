package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.utils.JobDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
    @Id
    private Long id;
    private String name;

    @Embedded
    private JobDetails jobDetails;
    private Long companyID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
