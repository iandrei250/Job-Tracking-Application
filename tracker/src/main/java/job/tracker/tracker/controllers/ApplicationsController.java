package job.tracker.tracker.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job.tracker.tracker.entities.JobApplication;
import job.tracker.tracker.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class ApplicationsController {
    private final JobService jobService = new JobService();

    @GetMapping
    public List<JobApplication> getAllJobs() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobById(@PathVariable UUID id) {
        return jobService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobApplication> createJob(@RequestBody JobApplication job) {
        return ResponseEntity.ok(jobService.create(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable UUID id) {
        boolean removed = jobService.delete(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
