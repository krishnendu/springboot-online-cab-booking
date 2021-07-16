<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            rel="stylesheet"
            href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
    />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>

    <link
            rel="stylesheet"
            href="https://unpkg.com/leaflet@1.2.0/dist/leaflet.css"
    />
    <link
            rel="stylesheet"
            href="https://unpkg.com/leaflet-routing-machine@latest/dist/leaflet-routing-machine.css"
    />
    <script src="https://unpkg.com/leaflet@1.2.0/dist/leaflet.js"></script>
    <script src="https://unpkg.com/leaflet-routing-machine@latest/dist/leaflet-routing-machine.js"></script>
    <link rel="stylesheet" href="/static/passenger-dashboard/global.css" />
    <title>Passenger Dashboard</title>
</head>
<body>

<div class="booking">
    <div class="journey">
        <h1 class="heading">Book your cab</h1>
        <div class="container">
            <input
                    type="text"
                    id="origin"
                    placeholder="From location"
                    value="Ruija Ajamtala"
                    required
            />
            <input
                    type="text"
                    id="destination"
                    placeholder="To location"
                    value="teghoria"
                    required
            />
            <!-- <input type="submit" value="Submit" /> -->
            <button id="booking">Booking</button>
        </div>
    </div>
</div>
<div id="mapid" class="details"></div>
<form style="display: none" method="PUT" id="locput" action="/">
    <input id="loclat" name = "lat" >
    <input id="loclng" name = "lng" >
</form>


<textarea style="display: none" id="allDrivers">${drivers}</textarea>
<textarea style="display: none" id="myLocation">${location}</textarea>
<script src="/static/passenger-dashboard/main.js"></script>
<%--<button style="position:fixed;top: 10px; right: 10px" onclick="putLocation()">Location</button>--%>


</body>
</html>