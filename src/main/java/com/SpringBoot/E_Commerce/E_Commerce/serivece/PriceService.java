package com.SpringBoot.E_Commerce.E_Commerce.serivece;

import com.SpringBoot.E_Commerce.E_Commerce.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
    Cart calculatePrice(Cart cart);
}
