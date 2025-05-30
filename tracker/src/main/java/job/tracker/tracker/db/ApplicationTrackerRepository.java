package job.tracker.tracker.db;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import job.tracker.tracker.entities.JobApplicationEntity;

public interface ApplicationTrackerRepository extends JpaRepository<JobApplicationEntity, UUID> {
    
}
