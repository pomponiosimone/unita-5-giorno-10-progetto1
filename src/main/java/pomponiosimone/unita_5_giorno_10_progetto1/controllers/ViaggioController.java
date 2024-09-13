package pomponiosimone.unita_5_giorno_10_progetto1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Viaggio;
import pomponiosimone.unita_5_giorno_10_progetto1.exceptions.BadRequestException;
import pomponiosimone.unita_5_giorno_10_progetto1.payloads.NewRespViaggioDTO;
import pomponiosimone.unita_5_giorno_10_progetto1.payloads.NewViaggioDTO;
import pomponiosimone.unita_5_giorno_10_progetto1.services.ViaggioService;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/viaggio")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    //1 GET ALL
    @GetMapping
    public List<Viaggio> findAll() {
        return this.viaggioService.findAll();
    }

    //2 POST
    @PostMapping("/{viaggiId}")
    @ResponseStatus(HttpStatus.CREATED)
    public NewRespViaggioDTO save(@RequestBody @Validated NewViaggioDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {

            String messages = validationResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));

            throw new BadRequestException("Ci sono stati errori nel payload. " + messages);
        } else {

            return new NewRespViaggioDTO(this.viaggioService.save(body).getId());
        }
    }
    // Get ID
    @GetMapping("/{viaggioid}")

    public Viaggio findyById(@PathVariable UUID viaggioid) {
        return this.viaggioService.findById(viaggioid);
    }

    //PUT
    @PutMapping("/{viaggioId}")
    public Viaggio findByIdAndUpdate(@PathVariable UUID viaggioid, @RequestBody Viaggio body) {
        return this.viaggioService.findByIdAndUpdate(viaggioid,body);

    }

    //Delete
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete (@PathVariable UUID viaggioId) {
        this.viaggioService.findByIdAndDelete(viaggioId);
    }

    }





