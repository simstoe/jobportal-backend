package at.simstoe.jobportal.backend.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Company extends Account {
    private String description;
}
