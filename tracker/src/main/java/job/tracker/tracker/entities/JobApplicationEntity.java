package job.tracker.tracker.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import job.tracker.tracker.entities.UserEntity;
import jakarta.persistence.CascadeType;


@Entity
@Table(name = "job_applications")
public class JobApplicationEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String status;

    private LocalDate appliedDate;

    @Column(length = 1000)
    private String notes;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public JobApplicationEntity() {}

    public JobApplicationEntity(String companyName, String position, String status, LocalDate appliedDate, String notes ) {
        this.companyName = companyName;
        this.position = position;
        this.status = status;
        this.appliedDate = appliedDate;
        this.notes = notes;
    }

        public UUID getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}