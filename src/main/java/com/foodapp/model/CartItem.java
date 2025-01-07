package com.foodapp.model;

public class CartItem {
	private String name;
    private int itemId;
    private int restaurantId;
    private int price;
    private int quantity;
    private String imagePath;

    public CartItem() {
        super();
    }

    public CartItem(String name,int itemId, int restaurantId, int price, int quantity, String imagePath) {
        super();
        this.name=name;
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.price = price;
        this.quantity = quantity;
        this.imagePath=imagePath;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getName() {
    	return name;
    }
    
    public void setimagePath(String imagePath) {
    	this.name = name;
    }
    public String getimagePath() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name+" "+itemId + " " + restaurantId + " " + price + " " + quantity+" "+imagePath;
    }
}
