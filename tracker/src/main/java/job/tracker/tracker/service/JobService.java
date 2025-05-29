package job.tracker.tracker.service;
import org.springframework.stereotype.Service;

import job.tracker.tracker.entities.JobApplication;

import java.time.LocalDate;
import java.util.*;

@Service
public class JobService {

    private final Map<UUID, JobApplication> jobApplications = new HashMap<>();

    public JobService() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        jobApplications.put(id1, new JobApplication(id1, "Google", "Frontend Developer", "APPLIED", LocalDate.now(), "Submitted via careers page"));
        jobApplications.put(id2, new JobApplication(id2, "Amazon", "Fullstack Engineer", "INTERVIEWING", LocalDate.now().minusDays(5), "HR round done"));
    }

    public List<JobApplication> getAll() {
        return new ArrayList<>(jobApplications.values());
    }

    public Optional<JobApplication> getById(UUID id) {
        return Optional.ofNullable(jobApplications.get(id));
    }

    public JobApplication create(JobApplication request) {
        UUID id = UUID.randomUUID();
        JobApplication job = new JobApplication(
            id,
            request.companyName(),
            request.position(),
            request.status(),
            request.appliedDate(),
            request.notes()
        );
        jobApplications.put(id, job);
        return job;
    }

    public boolean delete(UUID id) {
        return jobApplications.remove(id) != null;
    }
}
