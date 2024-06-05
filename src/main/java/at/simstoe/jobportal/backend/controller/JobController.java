package at.simstoe.jobportal.backend.controller;

import at.simstoe.jobportal.backend.models.Job;
import at.simstoe.jobportal.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(this.jobService.getJobs());
    }

    @PostMapping("/create")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        //TODO: check if job exist
        return ResponseEntity.ok(this.jobService.createJob(job));

    }
}
