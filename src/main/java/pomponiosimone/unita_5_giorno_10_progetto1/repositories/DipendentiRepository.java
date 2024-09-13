package pomponiosimone.unita_5_giorno_10_progetto1.repositories;

import pomponiosimone.unita_5_giorno_10_progetto1.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {
    Optional<Dipendente> findByEmail(String email);
}
