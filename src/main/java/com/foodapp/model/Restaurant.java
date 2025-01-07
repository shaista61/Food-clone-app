package com.foodapp.model;

public class Restaurant {	
	    private int restaurantId;
	    private String name;
	    private String cuisineType;
	    private int deliveryType;
	    private String address;
	    private float ratings;
	    private int isActive;
	    private String imagePath;

	    // Getters and Setters
	    public int getRestaurantId() {
	        return restaurantId;
	    }

	    public void setRestaurantId(int restaurantId) {
	        this.restaurantId = restaurantId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getCuisineType() {
	        return cuisineType;
	    }

	    public void setCuisineType(String cuisineType) {
	        this.cuisineType = cuisineType;
	    }

	    public int getDeliveryType() {
	        return deliveryType;
	    }

	    public void setDeliveryType(int deliveryType) {
	        this.deliveryType = deliveryType;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public float getRatings() {
	        return ratings;
	    }

	    public void setRatings(float ratings) {
	        this.ratings = ratings;
	    }

	    public int getIsActive() {
	        return isActive;
	    }

	    public void setIsActive(int isActive) {
	        this.isActive = isActive;
	    }

	    public String getImagePath() {
	        return imagePath;
	    }

	    public void setImagePath(String imagePath) {
	        this.imagePath = imagePath;
	    }

	    // Constructors
	    public Restaurant() {
	        super();
	    }

	    public Restaurant(int restaurantId, String name, String cuisineType, int deliveryType, String address, float ratings, int isActive, String imagePath) {
	        this.restaurantId = restaurantId;
	        this.name = name;
	        this.cuisineType = cuisineType;
	        this.deliveryType = deliveryType;
	        this.address = address;
	        this.ratings = ratings;
	        this.isActive = isActive;
	        this.imagePath = imagePath;
	    }

	    @Override
	    public String toString() {
	        return restaurantId + " " + name + " " + cuisineType + " " + deliveryType + " " + address + " " + ratings + " " + isActive + " " + imagePath;
	    }
	}


