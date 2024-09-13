package pomponiosimone.unita_5_giorno_10_progetto1.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "dipendenti")
@Getter
@Setter
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
  //  private String imgProfilo;//

    //COSTRUTTORI



    public Dipendente(String cognome, String email, String nome, String username) {
        this.cognome = cognome;
        this.email = email;
        this.nome = nome;
        this.username = username;
    }


    //TO STRING


    @Override
    public String toString() {
        return "Dipendente{" +
                "cognome='" + cognome + '\'' +
                ", username=" + username +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                //", imgProfilo='" + imgProfilo + '\'' +//
                '}';
    }
}
