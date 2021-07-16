var detail = document.getElementById("detail");
var booking = document.getElementById("booking");
var originName = document.getElementById("origin");
var destinationName = document.getElementById("destination");

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
    return `<iframe id="map_journey" 
    src="https://www.google.com/maps/embed?pb=
    !1m24!1m12!1m3!1d945263.6526381834!2d87.51985212440944!3d22.
    26146273206699!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m9!3e0!4m3!3m2!1d
    ${origin.lat}!2d${origin.lng}!4m3!3m2!1d${destination.lat}!2d${destination.lng}
    !5e0!3m2!1sen!2sin!4v1615145602931!5m2!1sen!2sin" style="border:0;" allowfullscreen="" loading="lazy"></iframe>`;
}
getDetails(originName.value,destinationName.value).then(data=>detail.innerHTML=data);
booking.onclick = ()=>{getDetails(originName.value,destinationName.value).then(data=>detail.innerHTML=data);}
