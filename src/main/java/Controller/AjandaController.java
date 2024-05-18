package Controller;

import com.example.ajandam.Entity.AjandaEntity;
import com.example.ajandam.Repository.AjandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "etkinlik")
public class AjandaController {

    @Autowired
    private AjandaRepository ajandaRepository;

    @GetMapping(path = "planim")
    public ResponseEntity<List<AjandaEntity>> getEtkinlik(@RequestParam(required = false) String etkinlikTuru,
                                                          @RequestParam(required = false) String etkinlikBasligi,
                                                          @RequestParam(required = false) String etkinlikIcerigi,
                                                          @RequestParam(required = false) LocalDateTime etkinlikTarihi,
                                                          @RequestParam(required = false) Time etkinlikSaati) {
        try {
            List<AjandaEntity> etkinlikList = new ArrayList<>();
            if (etkinlikTuru == null && etkinlikBasligi == null && etkinlikTarihi == null && etkinlikIcerigi == null && etkinlikSaati == null)
                return new ResponseEntity<>(ajandaRepository.findAll(), HttpStatus.OK);

            if (etkinlikTuru != null)
                ajandaRepository.findByEtkinlikTuru(etkinlikTuru).forEach(etkinlikList::add);
            if (etkinlikBasligi != null)
                ajandaRepository.findByEtkinlikBasligi(etkinlikBasligi).forEach(etkinlikList::add);
            if (etkinlikTarihi != null)
                ajandaRepository.findByEtkinlikTarihi(etkinlikTarihi).forEach(etkinlikList::add);
            if (etkinlikSaati != null)
                ajandaRepository.findByEtkinlikSaati(etkinlikSaati).forEach(etkinlikList::add);

            if (etkinlikList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etkinlikList, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "etkinlik/{id}")
    public ResponseEntity<?> getEtkinlikById(@PathVariable("id") Long ID) {
        Optional<AjandaEntity> etkinlikVeri = ajandaRepository.findById(ID);
        if (etkinlikVeri.isPresent()) {
            return new ResponseEntity<>(etkinlikVeri.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "etkinlik_ekle")
    public ResponseEntity<?> createEtkinlik(@RequestBody AjandaEntity etkinlik) {
        if (etkinlik == null) {
            return new ResponseEntity<>("Etkinlik bilgileri boş olamaz.", HttpStatus.BAD_REQUEST);
        }
        try {
            AjandaEntity _etkinlik = ajandaRepository.save(new AjandaEntity(etkinlik.getEtkinlikID(), etkinlik.getEtkinlikTuru(), etkinlik.getEtkinlikBasligi(), etkinlik.getEtkinlikIcerigi(), etkinlik.getEtkinlikTarihi(), etkinlik.getEtkinlikSaati(), LocalDateTime.now()));
            return new ResponseEntity<>(_etkinlik, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "etkinligi_guncelle")
    public ResponseEntity<AjandaEntity> updateEtkinlik(@PathVariable("id") Long ID, @RequestBody AjandaEntity etkinlik) {
        Optional<AjandaEntity> etkinlikVeri = ajandaRepository.findById(ID);

        if (etkinlikVeri.isPresent()) {
            AjandaEntity _etkinlik = etkinlikVeri.get();
            _etkinlik.setEtkinlikTuru(etkinlik.getEtkinlikTuru());
            _etkinlik.setEtkinlikBasligi(etkinlik.getEtkinlikBasligi());
            _etkinlik.setEtkinlikIcerigi(etkinlik.getEtkinlikIcerigi());
            _etkinlik.setEtkinlikTarihi(etkinlik.getEtkinlikTarihi());
            _etkinlik.setEtkinlikSaati(etkinlik.getEtkinlikSaati());
            return new ResponseEntity<>(ajandaRepository.save(_etkinlik), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/etkinlik_silme/{id}")
    public ResponseEntity<String> deleteEtkinlik(@PathVariable("id") Long id) {
        try {
            ajandaRepository.deleteById(id);
            return new ResponseEntity<>("Etkinlik başarıyla silindi", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Etkinlik silinirken bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
