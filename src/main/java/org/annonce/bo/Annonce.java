package org.annonce.bo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String adresse;
    private String mail;

    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    // Méthode qui s'exécute avant la persistance de l'entité (création)
    @PrePersist
    public void prePersist() {
        if (date == null) {
            date = LocalDateTime.now(); // Initialisation de la date à la création
        }
    }

    // Méthode qui s'exécute avant la mise à jour de l'entité
    @PreUpdate
    public void preUpdate() {
        date = LocalDateTime.now(); // Mise à jour de la date à chaque modification
    }
}
