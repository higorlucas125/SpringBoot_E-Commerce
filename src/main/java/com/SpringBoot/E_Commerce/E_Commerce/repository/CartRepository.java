package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <Cart, Integer> {
}
