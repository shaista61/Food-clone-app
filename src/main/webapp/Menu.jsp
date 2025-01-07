<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,com.foodapp.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5dc;
        }

        header {
            background-color: #d32f2f;
            color: #fff;
            padding: 15px 20px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }

        .menu-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start;
            gap: 100px;
            padding: 20px;
            position: relative;
            justify-content: center;
        }

        .menu-card {
            width: 300px;
            border: 1px solid #fff;
            border: 2px solid #d32f2f;
            border-radius: 8px;
            background-color: #fff;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            position: relative;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .menu-card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        }

        .menu-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .menu-card h3 {
            margin: 10px 0;
            font-size: 18px;
            color: #d32f2f;
        }

        .menu-card p {
            margin: 5px 10px;
            font-size: 14px;
            color: #555;
        }

        .menu-card p strong {
            color: #000;
        }

        .menu-card .price {
            font-size: 16px;
            color: #d32f2f;
            font-weight: bold;
        }

        .menu-card button {
            margin: 10px 0;
            padding: 8px 15px;
            font-size: 14px;
            color: #fff;
            background-color: #d32f2f;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .menu-card button:hover {
            background-color: #b71c1c;
        }

        @media (max-width: 768px) {
            .menu-card {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <%
            // Retrieve the list of menu items from the session
            List<Menu> menuList = (List<Menu>) session.getAttribute("menu");

            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) {
        %>
            <div class="menu-card">
                <img src="<%= menu.getImagePath() %>" alt="<%= menu.getName() %>">
                <h3><%= menu.getName() %></h3>
                <p><strong>Description:</strong> <%= menu.getDescription() %></p>
                <p class="price">Price: ₹<%= menu.getPrice() %></p>
                <form action="CartServlet" method="post">
                    <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="action" value="add">
                    <button type="submit">Add to Cart</button>
                </form>
            </div>
        <%
                }
            }
            else {
        %>
            <h1 style="text-align: center;">No menu items found!</h1>
            <p style="text-align: center;">It seems like there are no menu items available for this restaurant.</p>
        <%
            }
        %>
    </div>
</body>
</html>
