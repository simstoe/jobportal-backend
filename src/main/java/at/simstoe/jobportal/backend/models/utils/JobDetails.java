package at.simstoe.jobportal.backend.models.utils;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
