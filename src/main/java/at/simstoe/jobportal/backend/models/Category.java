package at.simstoe.jobportal.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Long id;
    private String name;
    private String hexCode;

    public Category(Category category) {
        this.id = category.id;
        this.name = category.name;
        this.hexCode = category.hexCode;
    }
}
