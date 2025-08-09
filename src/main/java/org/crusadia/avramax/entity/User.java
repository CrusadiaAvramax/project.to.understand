package org.crusadia.avramax.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends PanacheEntity {
    public String nome;
    public String email;
    public String bio;

    // Relazione One to Many con PortfolioItem
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Portfolio> portfolioItems;

    // Relazione One to One con Curriculum
    @OneToOne(cascade = CascadeType.ALL)
    public Curriculum curriculum;
}