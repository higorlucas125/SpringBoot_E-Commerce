package com.SpringBoot.E_Commerce.E_Commerce.serivece.serviceImpl;

import com.SpringBoot.E_Commerce.E_Commerce.model.Cart;
import com.SpringBoot.E_Commerce.E_Commerce.model.CartItem;
import com.SpringBoot.E_Commerce.E_Commerce.model.ProductDisplay;
import com.SpringBoot.E_Commerce.E_Commerce.model.User;
import com.SpringBoot.E_Commerce.E_Commerce.repository.CartItemRepository;
import com.SpringBoot.E_Commerce.E_Commerce.repository.CartRepository;
import com.SpringBoot.E_Commerce.E_Commerce.repository.ProductDisplayRepository;
import com.SpringBoot.E_Commerce.E_Commerce.repository.UserRepository;
import com.SpringBoot.E_Commerce.E_Commerce.serivece.CartService;
import com.SpringBoot.E_Commerce.E_Commerce.serivece.PriceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private static final Logger logger = Logger.getLogger( CartServiceImpl.class );

    @Autowired
    private PriceService priceService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductDisplayRepository productDisplayRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart addToCart(Principal principal, Integer id, Integer amount) throws IllegalAccessException {
        User user = getUserFromPrinciple(principal);
        if(amount <= 0 || id <= 0){
            throw new IllegalAccessException("Invalid parameters");
        }
        Cart cart = user.getCart();
        if( cart == null ){
            cart = new Cart();
            cart.setCartUser(user);
        }else if(cart.getCartItemList() != null || !cart.getCartItemList().isEmpty()){
            for (CartItem item : cart.getCartItemList()){
                if(item.getProductDisplay().getId().equals(id)){
                    item.setAmount(item.getAmount() + amount );
                    Cart returnCart = priceService.calculatePrice(cart);
                    cartRepository.save(returnCart);
                    return returnCart;
                }
            }
        }
        Optional optional = productDisplayRepository.findById(id);
        if (!optional.isPresent()) {
            throw new IllegalArgumentException("Product not found.");
        }

        ProductDisplay product = (ProductDisplay) optional.get();
        CartItem cartItem = new CartItem();
        cartItem.setAmount(amount);
        cartItem.setProductDisplay(product);

        //this will save the cart object as well because there is cascading from cartItem
        cartItem.setCart(cart);
        if (cart.getCartItemList() == null) {
            cart.setCartItemList(new ArrayList<>());
        }

        cart.getCartItemList().add(cartItem);

        cart = priceService.calculatePrice(cart);
        cartItemRepository.save(cartItem);
        return cart;
    }

    @Override
    public Cart fetchCart(Principal principal) {
        logger.info("FETCH CART");
        User user = getUserFromPrinciple(principal);
        return user.getCart();
    }

    @Override
    public Cart removeFromCart(Principal principal, Integer id) {
        logger.info("Remove CartItem id " + id);
        User user = getUserFromPrinciple(principal);
        Cart cart = user.getCart();
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found");
        }
        List<CartItem> cartItemsList = cart.getCartItemList();
        CartItem cartItemToDelete = null;
        for (CartItem i : cartItemsList) {
            if (i.getId().equals(id)) {
                cartItemToDelete = i;
            }
        }
        if( cartItemToDelete == null ){
            throw new IllegalArgumentException("CartItem not found");
        }

        cartItemsList.remove(cartItemToDelete);

        if(cart.getCartItemList() == null || cart.getCartItemList().size() == 0 ){
            user.setCart(null);
            userRepository.save(user);
            return null;
        }

        cart.setCartItemList(cartItemsList);
        cart = priceService.calculatePrice(cart);
        cartItemRepository.delete(cartItemToDelete);
        return cart;
    }

    @Override
    public Boolean confirmCart(Principal principal, Cart cart) {
        User user = getUserFromPrinciple(principal);
        Cart dbCart = user.getCart();
        if (dbCart == null) {
            throw new IllegalArgumentException("Cart not found");
        }
        List<CartItem> dbCartItemsList = dbCart.getCartItemList();
        List<CartItem> cartItemsList = cart.getCartItemList();
        if (dbCartItemsList.size() != cartItemsList.size()) {
            return false;
        }

        for (int i = 0; i < dbCartItemsList.size(); i++) {
            if (!dbCartItemsList.get(i).getId().equals(cartItemsList.get(i).getId()) &&
                    !dbCartItemsList.get(i).getAmount().equals(cartItemsList.get(i).getAmount()) &&
                    !dbCartItemsList.get(i).getProductDisplay().getId().equals(cartItemsList.get(i).getProductDisplay().getId())) {
                return false;
            }
        }
        if (
                dbCart.getTotalPrice().equals(cart.getTotalPrice())
                        && dbCart.getTotalCargoPrice().equals(cart.getTotalCargoPrice())
                        && dbCart.getId().equals(cart.getId())) {
            if (dbCart.getCartDiscount() != null && cart.getCartDiscount() != null) {
                if (dbCart.getCartDiscount().getDiscountPercent().equals(cart.getCartDiscount().getDiscountPercent())
                        && dbCart.getCartDiscount().getCode().equals(cart.getCartDiscount().getCode())) {
                    logger.info("equals");
                    return true;
                }
            } else if (dbCart.getCartDiscount() == null && cart.getCartDiscount() == null) {
                logger.info("equals");
                return true;
            }

        }
        logger.info("No u");
        logger.info(dbCart.getCartItemList().equals(cart.getCartItemList()));
        return false;
    }

    @Override
    public void emptyCart(Principal principal) {
        User user = getUserFromPrinciple(principal);
        user.setCart(null);
        userRepository.save(user);
    }

    private User getUserFromPrinciple(Principal principal) {
        if (principal == null || principal.getName() == null) {
            throw new IllegalArgumentException("Invalid access");
        }
        User user = userRepository.findByEmail(principal.getName());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }
}
