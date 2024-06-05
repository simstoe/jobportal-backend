package at.simstoe.jobportal.backend.service;

import at.simstoe.jobportal.backend.models.Job;
import at.simstoe.jobportal.backend.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public List<Job> getJobs() {
        return this.jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return this.jobRepository.findJobById(id);
    }
}
