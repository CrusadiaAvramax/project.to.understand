package org.crusadia.avramax.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User extends PanacheEntity {

    private String nome;
    private String cognome;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Set<String> roles;
    @Column(unique = true, nullable = false)
    private String email;
    private String bio;

    // Relazione One to Many con PortfolioItem
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Portfolio> portfolioItems;

    // Relazione One to One con Curriculum
    @OneToOne(cascade = CascadeType.ALL)
    private Curriculum curriculum;
}