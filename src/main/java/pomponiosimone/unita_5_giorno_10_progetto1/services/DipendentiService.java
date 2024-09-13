package pomponiosimone.unita_5_giorno_10_progetto1.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pomponiosimone.unita_5_giorno_10_progetto1.entities.Dipendente;
import pomponiosimone.unita_5_giorno_10_progetto1.exceptions.NotFoundException;
import pomponiosimone.unita_5_giorno_10_progetto1.payloads.NewDipendenteDTO;
import pomponiosimone.unita_5_giorno_10_progetto1.repositories.DipendentiRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DipendentiService {

    //IMPORTIAMO CLASSI

    @Autowired
    private DipendentiRepository dipendentiRepository;

 //   @Autowired
   // private Cloudinary cloudinary;

//Post
    public Dipendente saveD(NewDipendenteDTO body) {
        // 1
        this.dipendentiRepository.findByEmail(body.email()).ifPresent(
                dipendente -> {
                    try {
                        throw new BadRequestException("L'email " + body.email() + "è già in uso!");
                    } catch (BadRequestException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        // 2
        Dipendente newDipendente = new Dipendente(body.nome(), body.cognome(), body.email(), body.username());

        // 3
        return this.dipendentiRepository.save(newDipendente);
    }

    private List<Dipendente> dipendenteList = new ArrayList<>();

    // 2  GET TUTTI
    public List<Dipendente> findAll(){
        return this.dipendenteList;
    }

    // 2  GET ID
    public Dipendente findByIdD(UUID dipendenteId){
        return this.dipendentiRepository.findById(dipendenteId).orElseThrow(()-> new NotFoundException(dipendenteId));
    }
    // 3 DELETE
    public void findByIdAndDeletedD(UUID dipendenteId){
        Dipendente found = this.findByIdD(dipendenteId);
        this.dipendentiRepository.delete(found);
    }
    // 4  PUT
    public Dipendente findByIdAndUpdatedD(UUID dipendenteId, Dipendente newDipendenteData){
        // 4.1 Se la mail è già presente
        this.dipendentiRepository.findByEmail(newDipendenteData.getEmail()).ifPresent(
        dipendente -> {
            try {
                throw new BadRequestException("L'email " + newDipendenteData.getEmail() + "è già in uso");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        );
     Dipendente found = this.findByIdD(dipendenteId);
     found.setNome(newDipendenteData.getNome());
     found.setCognome(newDipendenteData.getCognome());
     found.setUsername(newDipendenteData.getUsername());
     found.setEmail(newDipendenteData.getEmail());
     return this.dipendentiRepository.save(found);
    }
    // 5 --> IMG CLOUDINARY
  //  public void uploadImg(MultipartFile file) throws IOException{
    //    String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
//System.out.println("URL: " + url);
   // }

}
