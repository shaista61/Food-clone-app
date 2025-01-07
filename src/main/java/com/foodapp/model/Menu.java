package com.foodapp.model;

public class Menu {
	 private int restaurantId;
	    private int menuId;
	    private String name;
	    private String description;
	    private int price;
	    private int isAvailable;
	    private String imagePath;

	    public Menu() {
	        super();
	    }

	    public Menu(int restaurantId, int menuId, String name, String description, int price, int isAvailable, String imagePath) {
	        super();
	        this.restaurantId = restaurantId;
	        this.menuId = menuId;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.isAvailable = isAvailable;
	        this.imagePath = imagePath;
	    }

	    public int getRestaurantId() {
	        return restaurantId;
	    }

	    public void setRestaurantId(int restaurantId) {
	        this.restaurantId = restaurantId;
	    }

	    public int getMenuId() {
	        return menuId;
	    }

	    public void setMenuId(int menuId) {
	        this.menuId = menuId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getIsAvailable() {
	        return isAvailable;
	    }

	    public void setIsAvailable(int isAvailable) {
	        this.isAvailable = isAvailable;
	    }

	    public String getImagePath() {
	        return imagePath;
	    }

	    public void setImagePath(String imagePath) {
	        this.imagePath = imagePath;
	    }

	    @Override
	    public String toString() {
	        return restaurantId + " " + menuId + " " + name + " " + description + " " + price + " " + isAvailable + " " + imagePath;
	    }
	}
