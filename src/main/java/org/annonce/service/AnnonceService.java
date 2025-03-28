package org.annonce.service;

import org.annonce.dto.AnnonceDTO;
import java.util.List;

public interface AnnonceService {
    AnnonceDTO createAnnonce(AnnonceDTO annonceDTO);
    List<AnnonceDTO> getAllAnnonces();
    AnnonceDTO getAnnonceById(Long id);
    AnnonceDTO updateAnnonce(Long id, AnnonceDTO annonceDTO);
    void deleteAnnonce(Long id);
}
