<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/static/register/global.css" />
    <title>Driver Registration</title>
</head>
<body>
<div class="booking">
    <div class="journey">
        <h1 class="heading">Driver Registration</h1>
        <form method="POST" class="container">
            <input
                    type="text"
                    placeholder="Fullname"
                    name="name"
                    required
            />
            <input
                    type="text"
                    placeholder="Username"
                    name="userName"
                    required
            />
            <input
                    type="password"
                    placeholder="Password"
                    name="password"
                    required
            />
            <input
                    type="number"
                    placeholder="Phone number"
                    name="phoneNumber"
            />
            <input
                    type="email"
                    placeholder="Email id"
                    name="email"
            />
            <input
                    type="text"
                    placeholder="Address"
                    name="address"
            />
            <input
                    type="text"
                placeholder="Cab Name"
                name = "cabName"

            />
            <input
                    type="text"
                    placeholder="Cab Model Number"
                    name = "cabModelNumber"
                    required
            />
            <input
                    type="number"
                    placeholder="Cab Total Seats"
                    name = "cabTotalSeats"
            />
            <input
                    type="text"
                    placeholder="Latitude"
                    name="lat"
                    id="lat"
                    style="display: none"
            />
            <input
                    type="text"
                    placeholder="Longitude"
                    name="lng"
                    id="lng"
                    style="display: none"
            />
            <input id="booking" type="submit" value="Submit" />
        </form>
    </div>
</div>
<script src="/static/register/main.js"></script>
</body>
</html>