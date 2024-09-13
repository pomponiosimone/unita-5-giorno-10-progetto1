package pomponiosimone.unita_5_giorno_10_progetto1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataRichiesta;

    private String annotazione;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Viaggio viaggio;


   



//COSTRUTTORI

    public Prenotazione(LocalDate dataRichiesta, Dipendente dipendente, Long id, String note, Viaggio viaggio) {
        this.dataRichiesta = dataRichiesta;
        this.dipendente = dipendente;
        this.id = id;
        this.annotazione = annotazione;
        this.viaggio = viaggio;
    }
    //TO STRING

    @Override
    public String toString() {
        return "Prenotazione{" +
                "dataRichiesta=" + dataRichiesta +
                ", id=" + id +
                ", dipendente=" + dipendente +
                ", viaggio=" + viaggio +
                ", annotazione='" + annotazione + '\'' +
                '}';
    }
}
