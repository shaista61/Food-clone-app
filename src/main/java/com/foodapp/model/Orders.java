package com.foodapp.model;

import java.sql.Timestamp;

public class Orders {
	private int restaurantId;
    private int ordersId;
    private int userId;
    private double totalAmount;
    private String status;
    private Timestamp orderDate;
    private String paymentMode;
    
    public Orders() {
        super();
    }

    public Orders(int restaurantId, int ordersId, Timestamp orderDate,int userId, double totalAmount, String status, String paymentMode) {
        super();
        this.restaurantId = restaurantId;
        this.ordersId = ordersId;
        this.orderDate=orderDate;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
    }

    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }
    public Timestamp getOrderDate() {
    	return orderDate;
    }
    
    public void setOrderDate(Timestamp OrderDate) {
    	this.orderDate = OrderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return ordersId + " " + restaurantId + " " +orderDate+" "+ userId + " " + totalAmount + " " + status + " " + paymentMode;
    }

}
