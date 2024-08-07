package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.utils.JobDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Job(Job job) {
        this.id = job.id;
        this.name = job.name;
        this.jobDetails = new JobDetails(job.jobDetails);
        this.companyID = job.companyID;
        this.category = new Category(job.category);
    }
}
