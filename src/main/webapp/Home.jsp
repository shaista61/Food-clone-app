<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.foodapp.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Details</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f5f5dc;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .header {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
        background-color: #d32f2f;
        color: #fff;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .header h1 {
        margin: 0;
        font-size: 24px;
    }
    .header .cart {
        font-size: 18px;
        cursor: pointer;
        text-decoration: none;
        color: #fff;
        background-color: #d32f2f;
        padding: 5px 15px;
        border-radius: 5px;
        transition: background-color 0.3s ease, color 0.3s ease;
    }
    .header .cart:hover {
        background-color: #fff;
        color: #d32f2f;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
    }
    .card {
        background-color: #fff;
        border: 2px solid #d32f2f;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s, box-shadow 0.3s;
        width: 300px;
        text-align: left;
        overflow: hidden;
    }
    .card:hover {
        transform: scale(1.05);
        box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
    }
    .card img {
        width: 100%;
        height: 200px;
        object-fit: cover;
    }
    .card h2 {
        font-size: 20px;
        color: #d32f2f;
        margin: 10px 15px;
    }
    .card p {
        font-size: 16px;
        color: #333;
        margin: 5px 15px;
    }
    .card .rating {
        color: #d32f2f;
        font-weight: bold;
    }
    .card .status {
        font-weight: bold;
        color: green;
    }
    .card .status.inactive {
        color: red;
    }
</style>
</head>
<body>
<div class="header">
    <h1>RESTAURANTS</h1>
    <a href="<%= request.getContextPath() %>/CartServlet" class="cart">Cart</a>
</div>
<h1>Hello <% out.println(session.getAttribute("userName")); %></h1>
<% 
    List<Restaurant> rlist = (List<Restaurant>) session.getAttribute("RestaurantList"); 
%>
<div class="card-container">
<% 
    for (Restaurant rl : rlist) { 
%>
    <div class="card">
        <a href="<%= request.getContextPath() %>/MenuServlet?id=<%= rl.getRestaurantId() %>">
        <img src="<%= rl.getImagePath() %>" alt="<%= rl.getName() %>">
    </a>
        <h2><%= rl.getName() %></h2>
        <p><strong>ID:</strong> <%= rl.getRestaurantId() %></p>
        <p><strong>Cuisine Type:</strong> <%= rl.getCuisineType() %></p>
        <p><strong>Delivery Type:</strong> <%= rl.getDeliveryType() == 1 ? "Dine-in & Delivery" : "Delivery Only" %></p>
        <p><strong>Address:</strong> <%= rl.getAddress() %></p>
        <p class="rating"><strong>Rating:</strong> <%= rl.getRatings() %> &#9733;</p>
        <p class="status <%= rl.getIsActive() == 1 ? "" : "inactive" %>">
            <strong>Status:</strong> <%= rl.getIsActive() == 1 ? "Active" : "Inactive" %>
        </p>
    </div>
<% 
    } 
%>
</div>
</body>
</html>
