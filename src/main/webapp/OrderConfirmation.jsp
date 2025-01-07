<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 93vh;
            background-color: beige;
            font-family: Arial, sans-serif;
            overflow: hidden;
            position: relative;
            border: 20px solid #d32f2f; /* Red border around the background */
        }

        .container {
            text-align: center;
            position: relative;
            z-index: 1;
        }

        .bike {
            position: absolute;
            bottom: 50px;
            left: -200px; /* Start from the left */
            width: 150px;
            animation: moveBike 4s ease-in-out forwards;
        }

        @keyframes moveBike {
            0% {
                left: -200px; /* Start from the left off-screen */
            }
            100% {
                left: 100vw; /* Move to the right edge of the screen */
            }
        }

        .message {
            font-size: 6rem;
            color: #333;
            opacity: 0;
            animation: fadeIn 2s ease-in forwards 2s;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .cracker {
            position: absolute;
            width: 10px;
            height: 10px;
            background-color: gold;
            border-radius: 50%;
            animation: burst 2s infinite ease-in-out;
            animation-play-state: paused; /* Pause the animation initially */
        }

        @keyframes burst {
            0% {
                transform: scale(0.5);
                opacity: 1;
            }
            50% {
                transform: scale(1.5);
                opacity: 0.7;
            }
            100% {
                transform: scale(0);
                opacity: 0;
            }
        }

        /* Randomize cracker positions */
        .cracker:nth-child(1) {
            top: 20%;
            left: 30%;
            animation-delay: 4s; /* Delay cracker animation until after text fades in */
        }
        .cracker:nth-child(2) {
            top: 50%;
            left: 70%;
            animation-delay: 4.5s;
        }
        .cracker:nth-child(3) {
            top: 80%;
            left: 40%;
            animation-delay: 5s;
        }
        .cracker:nth-child(4) {
            top: 30%;
            left: 60%;
            animation-delay: 5.5s;
        }
        .cracker:nth-child(5) {
            top: 70%;
            left: 20%;
            animation-delay: 6s;
        }

        /* Activate cracker animation after the text */
        .container.show-crackers .cracker {
            animation-play-state: running;
        }
    </style>
</head>
<body>
    <div class="container" id="container">
        <div class="message">Order Confirmed!</div>
        <img src="res_img/bike.png" alt="Bike" class="bike">
    </div>

    <!-- Cracker animations -->
    <div class="cracker"></div>
    <div class="cracker"></div>
    <div class="cracker"></div>
    <div class="cracker"></div>
    <div class="cracker"></div>

    <script>
        // Add a delay before triggering the cracker animations
        setTimeout(function() {
            document.getElementById('container').classList.add('show-crackers');
        }, 4000); // Starts after the message fade-in is complete (4s)
    </script>
</body>
</html>
