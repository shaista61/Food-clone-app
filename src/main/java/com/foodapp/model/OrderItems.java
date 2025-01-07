package com.foodapp.model;

public class OrderItems {
	private int ordersItemId;
    private int ordersId;
    private int menuId;
    private int quantity;
    private int totalItem;
    
    public OrderItems() {
        super();
    }

    public OrderItems(int ordersItemId, int ordersId, int menuId, int quantity, int totalItem) {
        super();
        this.ordersItemId = ordersItemId;
        this.ordersId = ordersId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.totalItem = totalItem;
    }
    public OrderItems(int ordersId, int menuId, int quantity, int totalItem) {
    	super();
    	//this.ordersItemId = ordersItemId;
    	this.ordersId = ordersId;
    	this.menuId = menuId;
    	this.quantity = quantity;
    	this.totalItem = totalItem;
    }

    // Getters and Setters
    public int getOrdersItemId() {
        return ordersItemId;
    }

    public void setOrdersItemId(int ordersItemId) {
        this.ordersItemId = ordersItemId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    @Override
    public String toString() {
        return ordersItemId + " " + ordersId + " " + menuId + " " + quantity + " " + totalItem;
    }

}
