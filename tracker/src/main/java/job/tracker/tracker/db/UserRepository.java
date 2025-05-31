package job.tracker.tracker.db;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import job.tracker.tracker.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
}
