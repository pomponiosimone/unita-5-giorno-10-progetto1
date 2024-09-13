package pomponiosimone.unita_5_giorno_10_progetto1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Dipendente;
import pomponiosimone.unita_5_giorno_10_progetto1.exceptions.BadRequestException;
import pomponiosimone.unita_5_giorno_10_progetto1.payloads.NewDipendenteDTO;
import pomponiosimone.unita_5_giorno_10_progetto1.services.DipendentiService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    // 1 --> GET ALL
    @GetMapping
    public List<Dipendente> findAllDipendenti(){
        return dipendentiService.findAll();
    }

    // 2 --> GET USERNAME
    @GetMapping("/{dipendenteUsername}")
    public Dipendente findByIdD(@PathVariable UUID dipendenteId){
        return this.dipendentiService.findByIdD(dipendenteId);
    }

    // 3 --> POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewDipendenteDTO saveD(@RequestBody @Validated NewDipendenteDTO body, BindingResult validationRisultato){
        if (validationRisultato.hasErrors()){
            String messages = validationRisultato.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException((" Ci sono errori nel payload " + messages));
        }else {
            return new NewDipendenteDTO(this.dipendentiService.saveD(body).getId());

        }
    }

    // 4 --> PUT
    @PutMapping("/{dipendenteUsername}")
    public Dipendente findByIdAndUpdateD(@PathVariable UUID dipendenteId, @RequestBody Dipendente body){
    return this.dipendentiService.findByIdAndUpdatedD(dipendenteId, body);
    }

    // 5 --> DELETE
    @DeleteMapping("/{dipendenteUsername}")
    public void findByIdAndDeleteD(@PathVariable UUID dipendenteId) {
        this.dipendentiService.findByIdAndDeletedD(dipendenteId);
    }

    // 6 --> UPLOAD
    @PostMapping("/{dipendenteUsername}/img")
    public void uploadImg(@RequestParam("img")MultipartFile image) throws IOException{
        this.dipendentiService.uploadImg(image);
    }


}
