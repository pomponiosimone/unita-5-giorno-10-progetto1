package pomponiosimone.unita_5_giorno_10_progetto1.payloads;

import java.time.LocalDateTime;

public record ErrorsResponseDTO(String message, LocalDateTime timestamp) {
}
