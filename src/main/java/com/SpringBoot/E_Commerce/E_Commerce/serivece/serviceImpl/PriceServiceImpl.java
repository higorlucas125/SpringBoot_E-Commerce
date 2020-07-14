package com.SpringBoot.E_Commerce.E_Commerce.serivece.serviceImpl;


import com.SpringBoot.E_Commerce.E_Commerce.model.Cart;
import com.SpringBoot.E_Commerce.E_Commerce.serivece.PriceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class PriceServiceImpl implements PriceService {

    private static final Logger logger = Logger.getLogger( PriceServiceImpl.class );

    @Override
    public Cart calculatePrice( Cart cart ) {

        final Float[] totalPrice = { 0F };
        final Float[] totalCargoPrice = { 0F };
        cart.getCartItemList().forEach( cartItem -> {
            logger.info( "amount " + cartItem.getAmount() );
            totalPrice[ 0 ] += ( ( cartItem.getProductDisplay().getPrice() + cartItem.getProductDisplay().getCargoPrice() ) * cartItem.getAmount() );
            totalCargoPrice[ 0 ] += ( ( cartItem.getProductDisplay().getCargoPrice() * cartItem.getAmount() ) );
        } );

        // Applying discount percent if exists

        if ( cart.getCartDiscount() != null ) {
            totalPrice[ 0 ] -= totalPrice[ 0 ] - ( ( totalPrice[ 0 ] * cart.getCartDiscount().getDiscountPercent() ) / 100 );
        }

        cart.setTotalPrice( roundTwoDecimals(totalPrice[0]));
        cart.setTotalCargoPrice( roundTwoDecimals(totalCargoPrice[0]));

        return cart;
    }


    private float roundTwoDecimals( float d ) {

        DecimalFormat twoDForm = new DecimalFormat( "#.##" );
        return Float.valueOf( twoDForm.format( d ) );
    }
}
