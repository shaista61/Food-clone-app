package com.foodapp.model;

public class OrderHistory {
	private int orderHistoryId;
    private int ordersId;
    private int userId;
    private double totalAmount;
    private String status;

    public int getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(int orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
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

    public OrderHistory() {
        super();
    }

    public OrderHistory(int orderHistoryId, int ordersId, int userId, double totalAmount, String status) {
        super();
        this.orderHistoryId = orderHistoryId;
        this.ordersId = ordersId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    public OrderHistory(int ordersId, int userId, double totalAmount, String status) {
    	super();
    	this.ordersId = ordersId;
    	this.userId = userId;
    	this.totalAmount = totalAmount;
    	this.status = status;
    }

    @Override
    public String toString() {
        return orderHistoryId + " " + ordersId + " " + userId + " " + totalAmount + " " + status;
    }

}
