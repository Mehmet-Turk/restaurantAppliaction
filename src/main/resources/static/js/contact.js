
    function initMap() {
      var location = {lat: 51.5074, lng: -0.1278}; // Set your desired coordinates

      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12, // Adjust the initial zoom level as needed
        center: location
      });

      var marker = new google.maps.Marker({
        position: location,
        map: map
      });
    }


