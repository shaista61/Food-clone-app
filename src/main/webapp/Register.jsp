<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2; /* Light grey background color */
            background-image: url('https://www.transparenttextures.com/patterns/pw-maze-white.png'); /* Small flower pattern */
            background-size: 20px 20px;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: #fff;
            padding: 20px; /* Reduced padding */
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 300px; /* Reduced max width */
            text-align: center;
            border: 2px solid #d32f2f; /* Red border */
        }

        h2 {
            color: #d32f2f; /* Red color for the title */
            margin-bottom: 20px;
        }

        label {
            font-size: 14px; /* Reduced label font size */
            color: #333;
            margin-bottom: 5px;
            display: block;
            text-align: left;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px; /* Reduced padding for input fields */
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 5px;
            margin-bottom: 15px; /* Reduced margin between fields */
        }

        input[type="submit"] {
            background-color: #d32f2f; /* Red button color */
            color: white;
            padding: 8px 16px; /* Reduced padding for the button */
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px; /* Reduced font size for the button */
            width: 100%;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #e04343; /* Darker red on hover */
        }

        p {
            color: #555;
            font-size: 14px;
        }

        a {
            color: #d32f2f;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Registration Form</h2>
        <form action="Register">
            <label for="name">Name</label>
            <input type="text" name="username" required>
            <label for="pswd">Password</label>
            <input type="password" name="pswd" required>
            <label for="Cpswd">Confirm Password</label>
            <input type="password" name="Cpswd" required>
            <label for="email">Email</label>
            <input type="text" name="email" required>
            <label for="address">Address</label>
            <input type="text" name="address" required>
            <input type="submit" value="Register">
        </form>
        <p>Already have an account? <a href="Login.jsp">Login here</a></p>
    </div>
</body>
</html>
