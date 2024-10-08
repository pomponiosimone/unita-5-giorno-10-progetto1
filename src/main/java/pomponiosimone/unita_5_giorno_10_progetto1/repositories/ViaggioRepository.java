package pomponiosimone.unita_5_giorno_10_progetto1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Viaggio;
import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository <Viaggio, UUID> {

}
