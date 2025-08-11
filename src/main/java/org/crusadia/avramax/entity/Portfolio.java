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
public class Portfolio extends PanacheEntity {

    private String titolo;
    private String descrizione;
    private String imageUrl;

    // Relazione Many to One con User
    @ManyToOne
    private User user;

    // Relazione Many to One con Categoria
    @ManyToOne
    private Categoria categoria;
}