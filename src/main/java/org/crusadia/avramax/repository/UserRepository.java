package org.crusadia.avramax.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.crusadia.avramax.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}