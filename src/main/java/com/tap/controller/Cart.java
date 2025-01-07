package com.tap.controller;
import java.util.HashMap;
import java.util.Map;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

public class Cart {
    private Map<Integer, CartItem> cartItems;

    public Cart() {
        this.cartItems = new HashMap<>();
    }
    //ADD
    public void addToCart(CartItem cart) {
            if(cartItems.containsKey(cart.getItemId())){
            	CartItem currentItem=cartItems.get(cart.getItemId());
            	currentItem.setQuantity(currentItem.getQuantity()+cart.getQuantity());
            }
            else {
            	int itemId=cart.getItemId();
            	cartItems.put(itemId, cart);
            }
        }

   //UPDATE
    public void updateCart(int ItemId, int quantity) {
        if (cartItems.containsKey(ItemId)) {
            CartItem item = cartItems.get(ItemId);
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                cartItems.remove(ItemId);
            }
        }
    }
    //REMOVE
    public void removeFromCart(int ItemId) {
        cartItems.remove(ItemId);
    }
    //FETCH
    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }
    //FETCH
    public void clearCart() {
        cartItems.clear();
    }
}
