package at.simstoe.jobportal.backend.service;

import at.simstoe.jobportal.backend.models.Category;
import at.simstoe.jobportal.backend.models.Job;
import at.simstoe.jobportal.backend.repository.CategoryRepository;
import at.simstoe.jobportal.backend.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final CategoryRepository categoryRepository;

    public List<Job> getJobs() {
        return this.jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return this.jobRepository.findJobById(id);
    }

    public Job createJob(Job job) {
        var category = categoryRepository.save(job.getCategory());
        job.setCategory(category);
        return this.jobRepository.save(job);
    }

    public Job updateJob(Job job) {
        var existingJob = this.jobRepository.findJobById(job.getId());

        if (existingJob == null) return null;
        existingJob = new Job(job);

        return this.jobRepository.save(existingJob);
    }

    public boolean deleteJobById(Long id) {
        var job = this.jobRepository.findJobById(id);

        if (job == null) return false;

        this.jobRepository.delete(job);

        return true;
    }
}
