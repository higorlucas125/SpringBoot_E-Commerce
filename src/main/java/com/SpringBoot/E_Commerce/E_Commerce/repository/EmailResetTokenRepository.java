package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.EmailRestToken;
import com.SpringBoot.E_Commerce.E_Commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailResetTokenRepository extends JpaRepository<EmailRestToken, Integer> {
    EmailRestToken findByToken(String Token);

    EmailRestToken findByUser(User user);
}
