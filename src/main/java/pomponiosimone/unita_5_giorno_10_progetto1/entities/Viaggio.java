package pomponiosimone.unita_5_giorno_10_progetto1.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pomponiosimone.unita_5_giorno_10_progetto1.enums.StatoViaggio;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "viaggi")
@Getter
@Setter
@NoArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String destinazione;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    // Costruttori
    public Viaggio(LocalDate data, String destinazione, StatoViaggio statoViaggio) {
        this.data = data;
        this.destinazione = destinazione;
        this.statoViaggio = statoViaggio;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", data=" + data +
                ", statoViaggio=" + statoViaggio +
                '}';
    }
}
