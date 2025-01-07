<!DOCTYPE html>
<%@ page import="java.util.Map" %>
<%@ page import="com.foodapp.model.CartItem,com.tap.controller.Cart" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5dc;
        }
        h1 {
            background-color: #d32f2f;
            color: #fff;
            padding: 15px 20px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }
        .cart-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }
        .cart-item {
            background-color: #fff;
            border: 2px solid #d32f2f;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        .cart-item img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 15px;
        }
        .cart-item h2 {
            font-size: 18px;
            margin-bottom: 10px;
            color: #333;
        }
        .cart-item p {
            margin: 10px 0;
            color: #333;
        }
        .cart-item form {
            margin-top: 10px;
        }
        .cart-item button {
            background-color: #d32f2f;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 8px 12px;
            cursor: pointer;
        }
        .cart-item button:hover {
            background-color: #b71c1c;
        }
        .cart-summary {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border: 2px solid #d32f2f;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .cart-summary p {
            margin: 10px 0;
            font-size: 18px;
            color: #333;
        }
        .cart-actions a {
            display: inline-block;
            margin: 8px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #d32f2f;
            color: white;
            border-radius: 5px;
        }
        .cart-actions a:hover {
            background-color: #b71c1c;
        }
        .empty-cart {
            text-align: center;
            margin-top: 50px;
            color: #333;
        }
        .empty-cart a {
            color: #d32f2f;
            text-decoration: none;
        }
        .empty-cart a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Your Shopping Cart</h1>

    <% 
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) { 
    %>
    <div class="empty-cart">
        <p>Your cart is empty. <a href="Menu.jsp">Continue Shopping</a></p>
    </div>
    <% 
        } else { 
    %>
    <div class="cart-container">
        <% 
            int grandTotal = 0; 
            for (Map.Entry<Integer, CartItem> entry : cart.getCartItems().entrySet()) {
                CartItem item = entry.getValue(); 
        %>
        <div class="cart-item">
            <h2><%= item.getName() %></h2>
            <p>Price: $<%= item.getPrice() %></p>
            <p>Quantity: <%= item.getQuantity() %></p>
            <p>Total: $<%= item.getPrice() * item.getQuantity() %></p>
            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                <button type="submit">Update</button>
            </form>
            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                <button type="submit">Remove</button>
            </form>
        </div>
        <% 
                grandTotal += item.getPrice() * item.getQuantity(); 
            } 
        %>
    </div>
    <div class="cart-summary">
        <p>Grand Total: $<%= grandTotal %></p>
        <div class="cart-actions">
            <a href="Menu.jsp">Add More Items</a>
            <a href="Checkout.jsp">Checkout</a>
        </div>
    </div>
    <% 
        } 
    %>
</body>
</html>
