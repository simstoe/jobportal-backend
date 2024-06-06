package at.simstoe.jobportal.backend.controller;

import at.simstoe.jobportal.backend.models.Job;
import at.simstoe.jobportal.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping("/")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(this.jobService.getJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        var job = this.jobService.getJobById(id);

        if (job == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(job);
    }

    @PostMapping("/")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        //TODO: check if job exist
        return ResponseEntity.ok(this.jobService.createJob(job));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        var isDeleted = this.jobService.deleteJobById(id);

        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
