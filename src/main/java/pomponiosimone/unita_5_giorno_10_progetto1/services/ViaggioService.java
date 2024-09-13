package pomponiosimone.unita_5_giorno_10_progetto1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Viaggio;
import pomponiosimone.unita_5_giorno_10_progetto1.exceptions.NotFoundException;
import pomponiosimone.unita_5_giorno_10_progetto1.payloads.NewViaggioDTO;
import pomponiosimone.unita_5_giorno_10_progetto1.repositories.ViaggioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    //trova tramite id
public Viaggio findById (UUID viaggioId) {
    return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException(viaggioId));
}
    //Trova ALL
    public List<Viaggio> findAll() {
        return this.viaggioRepository.findAll();
    }
        //Creazione

        public Viaggio creaViaggio(NewViaggioDTO newViaggioDTO) {
            Viaggio viaggio = new Viaggio();
            viaggio.setDestinazione(newViaggioDTO.destinazione());
            viaggio.setData(LocalDate.parse(newViaggioDTO.data()));
            viaggio.setStatoViaggio(Viaggio.StatoViaggio.valueOf(newViaggioDTO.statoViaggio().toUpperCase()));

            return viaggioRepository.save(viaggio);
        }

    }




