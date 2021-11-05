interface LocationType {
  id: string,
  name: string,
  locations: string
}




const mapContainerNode = document.getElementById("map");

let map: google.maps.Map;

function initMap(position) {
  map = new google.maps.Map(mapContainerNode, {
    center: {
      lat: position.coords.latitude,
      lng: position.coords.longitude
    },
    zoom: 15,
  });
}

function getMyPosition() {
  return new Promise(function (resolve, reject) {
    navigator.geolocation.getCurrentPosition(
      function (position) {
        resolve(position);
      },
      function (error) {
        reject(error);
      }
    );
  });
}
  
function addMarkers(locations) {
  for (let location of locations) {
    new google.maps.Marker({
    position: {
        lat: location.location.latitude,
        lng: location.location.longitude
      },
      map: map,
      label: location.name
    })
  }
}
  

function getLocations() {
  return fetch('https://www.vullum.io/academy/oslo.json')
  .then((response) => response.json())
  .then((locationTypes) => {
    let locationUrls = locationTypes
    .map((locationType) => locationType.locations);
    
    let locationPromises = locationUrls
    .map((url) => {
      return fetch(url)
      .then((response) => response.json())
    });
    
    let locations = Promise.all(locationPromises)
    .then((locationCollection) => {
      return locationCollection.flat();
    })
    
    return locations;
  })
}
  
async function main() {
  try {
    const myPosition = await getMyPosition();
    initMap(myPosition);
    const locations = await getLocations();
    addMarkers(locations);
  } catch (error) {
    console.log(error);
  }
}

main();