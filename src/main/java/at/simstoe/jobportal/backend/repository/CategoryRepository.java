package at.simstoe.jobportal.backend.repository;

import at.simstoe.jobportal.backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
