
package job.tracker.tracker.dtos;
import java.time.LocalDate;
import java.util.UUID;

public record JobApplicationDTO(
    UUID id,
    String companyName,
    String position,
    String status,
    LocalDate appliedDate,
    UUID userId
) {}
