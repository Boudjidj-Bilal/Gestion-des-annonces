package org.annonce.service;

import org.annonce.dto.AnnonceDTO;
import org.annonce.bo.Annonce;
import org.annonce.mapper.AnnonceMapper;
import org.annonce.repository.AnnonceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnnonceServiceImplTest {

    @Mock
    private AnnonceRepository annonceRepository;

    @Mock
    private AnnonceMapper annonceMapper;

    @InjectMocks
    private AnnonceServiceImpl annonceService;

    private Annonce annonce;
    private AnnonceDTO annonceDTO;

    @BeforeEach
    void setUp() {
        annonce = new Annonce();
        annonce.setId(1L);
        annonce.setTitre("Titre Test");
        annonce.setDescription("Description Test");
        annonce.setAdresse("Adresse Test");
        annonce.setMail("test@mail.com");

        annonceDTO = new AnnonceDTO();
        annonceDTO.setId(1L);
        annonceDTO.setTitre("Titre Test");
        annonceDTO.setDescription("Description Test");
        annonceDTO.setAdresse("Adresse Test");
        annonceDTO.setMail("test@mail.com");
    }

    @Test
    void testCreateAnnonce() {
        when(annonceMapper.toEntity(any(AnnonceDTO.class))).thenReturn(annonce);
        when(annonceRepository.save(any(Annonce.class))).thenReturn(annonce);
        when(annonceMapper.toDTO(any(Annonce.class))).thenReturn(annonceDTO);

        AnnonceDTO result = annonceService.createAnnonce(annonceDTO);

        assertNotNull(result);
        assertEquals("Titre Test", result.getTitre());

        verify(annonceMapper, times(1)).toEntity(any(AnnonceDTO.class));
        verify(annonceRepository, times(1)).save(any(Annonce.class));
        verify(annonceMapper, times(1)).toDTO(any(Annonce.class));
    }

    @Test
    void testGetAllAnnonces() {
        List<Annonce> annonces = List.of(annonce);
        List<AnnonceDTO> annoncesDTO = List.of(annonceDTO);

        when(annonceRepository.findAll()).thenReturn(annonces);
        when(annonceMapper.toDTO(annonce)).thenReturn(annonceDTO);

        List<AnnonceDTO> result = annonceService.getAllAnnonces();

        assertEquals(1, result.size());
        assertEquals("Titre Test", result.get(0).getTitre());

        verify(annonceRepository, times(1)).findAll();
        verify(annonceMapper, times(1)).toDTO(annonce);
    }

    @Test
    void testGetAnnonceById_Found() {
        when(annonceRepository.findById(1L)).thenReturn(Optional.of(annonce));
        when(annonceMapper.toDTO(any(Annonce.class))).thenReturn(annonceDTO);

        AnnonceDTO result = annonceService.getAnnonceById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(annonceRepository, times(1)).findById(1L);
        verify(annonceMapper, times(1)).toDTO(any(Annonce.class));
    }

    @Test
    void testGetAnnonceById_NotFound() {
        when(annonceRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            annonceService.getAnnonceById(1L);
        });

        assertEquals("Annonce introuvable", exception.getMessage());

        verify(annonceRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateAnnonce() {
        when(annonceRepository.findById(1L)).thenReturn(Optional.of(annonce));
        // when(annonceMapper.toEntity(any(AnnonceDTO.class))).thenReturn(annonce);
        when(annonceRepository.save(any(Annonce.class))).thenReturn(annonce);
        when(annonceMapper.toDTO(any(Annonce.class))).thenReturn(annonceDTO);

        AnnonceDTO result = annonceService.updateAnnonce(1L, annonceDTO);

        assertNotNull(result);
        assertEquals("Titre Test", result.getTitre());

        verify(annonceRepository, times(1)).findById(1L);
        // verify(annonceMapper, times(1)).toEntity(any(AnnonceDTO.class));
        verify(annonceRepository, times(1)).save(any(Annonce.class));
        verify(annonceMapper, times(1)).toDTO(any(Annonce.class));
    }

    @Test
    void testDeleteAnnonce() {
        doNothing().when(annonceRepository).deleteById(1L);

        annonceService.deleteAnnonce(1L);

        verify(annonceRepository, times(1)).deleteById(1L);
    }
}
