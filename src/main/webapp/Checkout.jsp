<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
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
        .checkout-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 2px solid #d32f2f;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        input, select, textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        textarea {
            resize: vertical;
        }
        .payment-method {
            margin: 10px 0;
        }
        .payment-method label {
            display: inline-block;
            font-weight: normal;
        }
        button {
            background-color: #d32f2f;
            color: white;
            padding: 10px 15px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #b71c1c;
        }
    </style>
</head>
<body>
    <h1>Checkout</h1>
    <div class="checkout-container">
        <form action="CheckoutServlet" method="post">
            <!-- Address Details -->
            <div class="form-group">
                <label for="fullName">Full Name</label>
                <input type="text" id="fullName" name="fullName" placeholder="Enter your full name" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <textarea id="address" name="address" rows="4" placeholder="Enter your address" required></textarea>
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" id="city" name="city" placeholder="Enter your city" required>
            </div>
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="Enter your state" required>
            </div>
            <div class="form-group">
                <label for="zip">ZIP Code</label>
                <input type="text" id="zip" name="zip" placeholder="Enter your ZIP code" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required>
            </div>

            <!-- Payment Method -->
            <div class="form-group">
                <label>Payment Method</label>
                <div class="payment-method">
                    <input type="radio" id="creditCard" name="paymentMethod" value="Credit Card" required>
                    <label for="creditCard">Credit Card</label>
                </div>
                <div class="payment-method">
                    <input type="radio" id="debitCard" name="paymentMethod" value="Debit Card">
                    <label for="debitCard">Debit Card</label>
                </div>
                <div class="payment-method">
                    <input type="radio" id="netBanking" name="paymentMethod" value="Net Banking">
                    <label for="netBanking">Net Banking</label>
                </div>
                <div class="payment-method">
                    <input type="radio" id="cashOnDelivery" name="paymentMethod" value="Cash on Delivery">
                    <label for="cashOnDelivery">Cash on Delivery</label>
                </div>
            </div>

            <!-- Submit Button -->
            <button type="submit">Place Order</button>
        </form>
    </div>
</body>
</html>
