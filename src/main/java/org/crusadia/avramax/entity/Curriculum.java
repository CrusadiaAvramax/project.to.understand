package org.crusadia.avramax.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curriculum extends PanacheEntity {

    private String fileUrl;
    private String descrizione;

    // Relazione One to One con User
    @OneToOne(mappedBy = "curriculum")
    private User user;


}