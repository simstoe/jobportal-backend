package at.simstoe.jobportal.backend.models.utils;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JobDetails {
    private String jobDescription;
    @ElementCollection
    private List<String> requirements;
    private double salary;
    private String timeModel;
    private String location;

    public JobDetails(JobDetails jobDetails) {
        this.jobDescription = jobDetails.jobDescription;
        // Maybe not a deep copy
        this.requirements = jobDetails.requirements.stream().toList();
        this.salary = jobDetails.salary;
        this.timeModel = jobDetails.timeModel;
        this.location = jobDetails.location;
    }
}
