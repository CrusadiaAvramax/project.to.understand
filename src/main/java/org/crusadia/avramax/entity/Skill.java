package org.crusadia.avramax.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill extends PanacheEntity {
    public String nome; // Es: "Java", "Photoshop"
    public String livello; // Es: "Esperto", "Intermedio"

    // Relazione Many to One con User
    @ManyToOne
    public User user;
}
