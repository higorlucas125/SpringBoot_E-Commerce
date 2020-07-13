package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.PasswordForgotToken;
import com.SpringBoot.E_Commerce.E_Commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordForgotTokenRepository extends JpaRepository<PasswordForgotToken, Integer> {
    PasswordForgotToken findByToken(String token);

    PasswordForgotToken findByUser(User user);
}
