var linksToFetch = [];
function getLocationLinks(result){
  for (let link of result){
    linksToFetch.push(link.locations)
  }
}

var getPlaces = fetch('https://www.vullum.io/academy/oslo.json')
.then((response)=>response.json())
.then(result => getLocationLinks(result))


function getLocations(){
  let allLocations = fetch('https://www.vullum.io/academy/oslo.json')
  .then((response)=>response.json())
  .then((locationTypes)=> {
    let locationUrls = locationTypes
    .map((locationType)=>locationType.locations);

    let locationPromises = locationUrls
    .map((url)=>{
      return fetch(url)
      .then((response)=>response.json())
    });
    
    let locations = Promise.all(locationPromises)
    .then((locationCollection)=>{
      return locationCollection.flat();
    })
    return locations
  })
}