package at.simstoe.jobportal.backend.repository;

import at.simstoe.jobportal.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findJobById(Long id);
}
