package job.tracker.tracker.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import job.tracker.tracker.db.ApplicationTrackerRepository;
import job.tracker.tracker.db.UserRepository;
import job.tracker.tracker.dtos.JobApplicationDTO;
import job.tracker.tracker.entities.JobApplicationEntity;
import job.tracker.tracker.entities.UserEntity;

@Service
public class JobService {

   private final ApplicationTrackerRepository repository;
   private final UserRepository userRepository;

    public JobService(ApplicationTrackerRepository repository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    public List<JobApplicationDTO> getAll() {
        return repository.findAll().stream()
        .map(app -> new JobApplicationDTO(
            app.getId(),
            app.getCompanyName(),
            app.getPosition(),
            app.getStatus(),
            app.getAppliedDate(),
            app.getUser() != null ? app.getUser().getId() : null
        ))
        .toList();
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

    public void applyToJob(UUID jobId, UUID userId) {

        UserEntity user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        JobApplicationEntity application = repository.findById(jobId)
            .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setUser(user);
        repository.save(application);
    }
}
