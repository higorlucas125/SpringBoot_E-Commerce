package com.SpringBoot.E_Commerce.E_Commerce.serivece;

import com.SpringBoot.E_Commerce.E_Commerce.model.Cart;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface CartService {
    Cart addToCart(Principal principal, Integer id, Integer amount) throws IllegalAccessException;

    Cart fetchCart(Principal principal);

    Cart removeFromCart(Principal principal, Integer id);

    Boolean confirmCart(Principal principal, Cart cart);

    void emptyCart(Principal principal);

}
