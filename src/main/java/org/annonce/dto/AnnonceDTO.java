package org.annonce.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDTO {
    private Long id;
    private String titre;
    private String description;
    private String adresse;
    private String mail;
    private LocalDateTime date;
}
