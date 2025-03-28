package org.annonce.mapper;

import org.annonce.bo.Annonce;
import org.annonce.dto.AnnonceDTO;
import org.springframework.stereotype.Component;

@Component
public class AnnonceMapper {

    public AnnonceDTO toDTO(Annonce annonce) {
        return new AnnonceDTO(
                annonce.getId(),
                annonce.getTitre(),
                annonce.getDescription(),
                annonce.getAdresse(),
                annonce.getMail(),
                annonce.getDate()
        );
    }

    public Annonce toEntity(AnnonceDTO annonceDTO) {
        return new Annonce(
                annonceDTO.getId(),
                annonceDTO.getTitre(),
                annonceDTO.getDescription(),
                annonceDTO.getAdresse(),
                annonceDTO.getMail(),
                annonceDTO.getDate()
        );
    }
}
