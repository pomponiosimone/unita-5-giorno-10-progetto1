package pomponiosimone.unita_5_giorno_10_progetto1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Viaggio;
import pomponiosimone.unita_5_giorno_10_progetto1.enums.StatoViaggio;
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
    public Viaggio findById(UUID viaggioId) {
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException(viaggioId));
    }

    //Trova ALL
    public List<Viaggio> findAll() {
        return this.viaggioRepository.findAll();
    }

    //Creazione
    public Viaggio creaViaggio(NewViaggioDTO body) {
        Viaggio newViaggio = new Viaggio(
                LocalDate.parse(body.data()),
                body.destinazione(),
                StatoViaggio.valueOf(body.statoViaggio().toUpperCase())
        );
        return this.viaggioRepository.save(newViaggio);

    }

    //Trova id e elimina
    public void findByIdAndDelete(UUID viaggioId) {
        Viaggio found = this.findById(viaggioId);
        this.viaggioRepository.delete(found);
    }

    //Trova id e modifica
    public Viaggio findByIdAndUpdate(UUID viaggioId, Viaggio newViaggioData){
        Viaggio found = this.findById(viaggioId);
        found.setData(newViaggioData.getData());
        found.setStatoViaggio(newViaggioData.getStatoViaggio());
        found.setDestinazione(newViaggioData.getDestinazione());
        return this.viaggioRepository.save(found);
    }

}





