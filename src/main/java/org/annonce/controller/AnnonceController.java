package org.annonce.controller;

import org.annonce.dto.AnnonceDTO;
import org.annonce.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/annonces")
@CrossOrigin(origins = "*")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping
    public AnnonceDTO createAnnonce(@RequestBody AnnonceDTO annonceDTO) {
        return annonceService.createAnnonce(annonceDTO);
    }

    @GetMapping
    public List<AnnonceDTO> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @GetMapping("/{id}")
    public AnnonceDTO getAnnonceById(@PathVariable Long id) {
        return annonceService.getAnnonceById(id);
    }

    @PutMapping("/{id}")
    public AnnonceDTO updateAnnonce(@PathVariable Long id, @RequestBody AnnonceDTO annonceDTO) {
        return annonceService.updateAnnonce(id, annonceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
    }
}
