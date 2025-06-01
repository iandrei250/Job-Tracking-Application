package job.tracker.tracker.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity { 

    @Id
    @GeneratedValue
    private UUID id;
    
    private String username;
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobApplicationEntity> applications = new ArrayList<>();

    public UserEntity() {}

    public UserEntity(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

       public UUID getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<JobApplicationEntity> getApplications() {
        return applications;
    }

    public void setApplications(List<JobApplicationEntity> applications) {
        this.applications = applications;
    }
}