package job.tracker.tracker.service;
import org.springframework.stereotype.Service;

import job.tracker.tracker.db.ApplicationTrackerRepository;
import job.tracker.tracker.entities.JobApplicationEntity;
import java.util.*;

@Service
public class JobService {

   private final ApplicationTrackerRepository repository;

    public JobService(ApplicationTrackerRepository repository) {
        this.repository = repository;
    }

    public List<JobApplicationEntity> getAll() {
        return repository.findAll();
    }

    public Optional<JobApplicationEntity> getById(UUID id) {
        return repository.findById(id);
    }

    public JobApplicationEntity create(JobApplicationEntity application) {
        return repository.save(application);
    }

    public Optional<JobApplicationEntity> update(UUID id, JobApplicationEntity updated) {
        return repository.findById(id).map(existing -> {
            existing.setCompanyName(updated.getCompanyName());
            existing.setPosition(updated.getPosition());
            existing.setStatus(updated.getStatus());
            existing.setAppliedDate(updated.getAppliedDate());
            existing.setNotes(updated.getNotes());
            return repository.save(existing);
        });
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
