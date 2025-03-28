package org.annonce.service;


import org.annonce.bo.Annonce;
import org.annonce.dto.AnnonceDTO;
import org.annonce.mapper.AnnonceMapper;
import org.annonce.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private AnnonceMapper annonceMapper;

    @Override
    public AnnonceDTO createAnnonce(AnnonceDTO annonceDTO) {
        Annonce annonce = annonceMapper.toEntity(annonceDTO);
        return annonceMapper.toDTO(annonceRepository.save(annonce));
    }

    @Override
    public List<AnnonceDTO> getAllAnnonces() {
        return annonceRepository.findAll().stream()
                .map(annonceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnnonceDTO getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .map(annonceMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Annonce introuvable"));
    }

    @Override
    public AnnonceDTO updateAnnonce(Long id, AnnonceDTO annonceDTO) {
        Annonce annonce = annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce introuvable"));

        annonce.setTitre(annonceDTO.getTitre());
        annonce.setDescription(annonceDTO.getDescription());
        annonce.setAdresse(annonceDTO.getAdresse());
        annonce.setMail(annonceDTO.getMail());

        return annonceMapper.toDTO(annonceRepository.save(annonce));
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}

