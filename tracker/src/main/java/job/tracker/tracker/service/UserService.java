package job.tracker.tracker.service;

import org.springframework.stereotype.Service;

import job.tracker.tracker.db.UserRepository;
import job.tracker.tracker.entities.UserEntity;

import java.util.*;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

        public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserEntity> getUserById(UUID id) {
        return repository.findById(id);
    }

    public UserEntity createUser(UserEntity user) {
        return repository.save(user);
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }
}
