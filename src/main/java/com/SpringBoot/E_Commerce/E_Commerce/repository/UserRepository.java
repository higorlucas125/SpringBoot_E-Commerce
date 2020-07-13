package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
