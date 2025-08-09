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
    public String titolo;
    public String descrizione;
    public String imageUrl;

    // Relazione Many to One con User
    @ManyToOne
    public User user;

    // Relazione Many to One con Categoria
    @ManyToOne
    public Categoria categoria;
}