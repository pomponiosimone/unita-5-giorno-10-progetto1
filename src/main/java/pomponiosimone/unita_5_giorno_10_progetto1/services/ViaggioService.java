package pomponiosimone.unita_5_giorno_10_progetto1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomponiosimone.unita_5_giorno_10_progetto1.repositories.ViaggioRepository;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

}
