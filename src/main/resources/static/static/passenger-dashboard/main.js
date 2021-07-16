// var map = document.getElementById("mapid");
var booking = document.getElementById("booking");
var originName = document.getElementById("origin");
var destinationName = document.getElementById("destination");

function putLocation(){
    if(userlocation) {
        document.getElementById("loclat").value = userlocation.lat;
        document.getElementById("loclng").value = userlocation.lng;
        document.getElementById("locput").submit();
    }
}




var userlocation;
// fetch("http://6d63914df1e9.ngrok.io/api/passenger/passenger2/location")
//     .then(response => response.json())
//     .then(data => destinationLocation=data);
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        console.log("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    userlocation = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
    }
    console.log(userlocation);
}
getLocation();

function putLocation(){
    if(userlocation) {
        document.getElementById("loclat").value = userlocation.lat;
        document.getElementById("loclng").value = userlocation.lng;
        document.getElementById("locput").submit();
    }
}

async function getLink(value) {
    let link = `https://nominatim.openstreetmap.org/search.php?q=${value}&polygon_geojson=1&format=jsonv2`;
    await fetch(link)
        .then(data => data.json())
        .then(data => {
            lat = data[0].lat
            lng = data[0].lon
        });
    return {lat,lng};
}

async function getDetails(value1,value2) {
    var origin,destination;
    await getLink(value1)
        .then(data=> origin=data);
    await getLink(value2)
        .then(data=> destination=data);
    mapCreate(JSON.parse(document.querySelector("#myLocation").innerText),destination);
    // return {origin,destination};
}
// getDetails(originName.value,destinationName.value).then(data=>data);
booking.onclick = ()=>{getDetails(originName.value,destinationName.value).then(data=>data);}



var mymap=0;
function mapCreate(origin,destination){
    if(mymap)
    mymap.remove();
    mymap= L.map('mapid');
    mymap.setView([(origin.lat/2 + destination.lat/2),(origin.lng/2 + destination.lng/2)],8);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'your.mapbox.access.token'
    }).addTo(mymap);

    let bookedDriverLoc=nearestCab();
    var circle = L.circle([bookedDriverLoc.lat,bookedDriverLoc.lng], {
        color: '#6f8',
        fillColor: '#6f8',
        fillOpacity: 0.5,
        radius: 500
    }).addTo(mymap);
    L.Routing.control({
        waypoints: [
        L.latLng(bookedDriverLoc.lat,bookedDriverLoc.lng),
        L.latLng(origin.lat,origin.lng),
        L.latLng(destination.lat,destination.lng)
        ]
    }).addTo(mymap);


    var driverIcon = L.icon({
        iconUrl: 'https://images.vexels.com/media/users/3/154385/isolated/preview/184aacae8933089983daa66c9f2c037b-compact-car-top-view-silhouette-by-vexels.png',
        iconSize: [50, 50],
        iconAnchor: [20, 20]
    });
    var userIcon = L.icon({
        iconUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Person_icon_BLACK-01.svg/962px-Person_icon_BLACK-01.svg.png',
        iconSize: [50, 50],
        iconAnchor: [20, 20]
    });
    
    function addItemToMap(){
        JSON.parse(document.querySelector("#allDrivers").innerText).forEach(driver => {
                L.marker([driver.location.lat,driver.location.lng], {icon: driverIcon}).addTo(mymap);
            });
        
        L.marker([origin.lat,origin.lng], {icon: userIcon}).addTo(mymap);

    }
    function nearestCab(){
        let driverdistance=10000;
        let driverLocation,driverName;
        JSON.parse(document.querySelector("#allDrivers").innerText).forEach(driver => {
            if(driverdistance>driver.distanceFromUser){
                driverLocation=driver.location;
                driverdistance=driver.distanceFromUser;
                driverName=driver.userName;
            }
        });
        console.log(driverName);
        return driverLocation;
    }
    
    addItemToMap();
    // getDistance([origin.lat,origin.lng], [destination.lat,destination.lng])
}
