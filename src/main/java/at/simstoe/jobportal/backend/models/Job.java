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
    @Column(nullable = false, updatable = false, unique = true)
    @SequenceGenerator(name = "jobModel_sequence", sequenceName = "jobModel_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobModel_sequence")
    private Long id;
    private String name;

    @Embedded
    private JobDetails jobDetails;
    private Long companyID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
