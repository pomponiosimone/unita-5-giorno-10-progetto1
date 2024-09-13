package pomponiosimone.unita_5_giorno_10_progetto1.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record NewDipendenteDTO(

        @NotEmpty(message = "Inserisci il nome")
@Size(min = 4, max = 30, message = "Il nome deve essere compreso tra 3 e 50 caratteri")
        String nome,
        @NotEmpty(message = "Non hai inserito il cognome")
        @Size(min = 4, max = 35, message = "Il cognome deve essere compreso tra 3 e 40 caratteri")
        String cognome,
        @NotEmpty(message = "username non valido")
        @Size(min = 2, max = 10, message = "stato deve essere compreso tra 2 e 10 caratteri")
        String username,
        @NotEmpty(message = "Non hai inserito l'email")
        @Email(message = "L'email inserita non è valida")
        String email) {
      }


