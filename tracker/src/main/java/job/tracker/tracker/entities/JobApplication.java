package job.tracker.tracker.entities;

import java.time.LocalDate;
import java.util.UUID;

public record JobApplication(
    UUID id,
    String companyName,
    String position,
    String status,
    LocalDate appliedDate,
    String notes
) {}
