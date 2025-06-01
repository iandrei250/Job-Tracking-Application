package job.tracker.tracker.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job.tracker.tracker.entities.JobApplicationEntity;
import job.tracker.tracker.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class ApplicationsController {
    private final JobService jobService;

    public ApplicationsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobApplicationEntity> getAllJobs() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationEntity> getJobById(@PathVariable UUID id) {
        return jobService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobApplicationEntity> createJob(@RequestBody JobApplicationEntity job) {
        return ResponseEntity.ok(jobService.create(job));
    }

     @PutMapping("/{id}")
    public ResponseEntity<JobApplicationEntity> updateApplication(@PathVariable UUID id, @RequestBody JobApplicationEntity updated) {
        return jobService.update(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable UUID id) {
        jobService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{jobId}/apply/{userId}")
    public ResponseEntity<Void> applyToJob(@PathVariable UUID jobId, @PathVariable UUID userId) {
        jobService.applyToJob(jobId, userId);
        return ResponseEntity.ok().build();
    }
}
