fetch('https://jsonplaceholder.typicode.com/posts', {
    method: 'POST',
    body: JSON.stringify({

    }),
    headers: {
        'Content-type': 'application/json; charset=UTF-8'
    }
}).then(function (response) {
    if (response.ok) {
        return response.json();
    }
    return Promise.reject(response);
}).then(function (data) {
    console.log(data);
}).catch(function (error) {
    console.warn('Something went wrong.', error);
});



function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        console.log("Geolocation is not supported by this browser.");
    }
}
function showPosition(position) {
    document.getElementById("lat").value = position.coords.latitude;
    document.getElementById("lng").value = position.coords.longitude;
}
getLocation();