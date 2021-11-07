var getAllResponses = Promise.all([
  fetch('https://pokeapi.co/api/v2/pokemon/2/'),
  fetch('https://pokeapi.co/api/v2/pokemon/3/'),
  fetch('https://pokeapi.co/api/v2/pokemon/4/')
])
.then(function(responses){
  return Promise.all(responses.map(function(response){
    return response.json();
  }))
})


getAllResponses.then(function(pokemons){
  console.log(pokemons)
})
.catch(function(error){
  console.log(error)
})

// Arrow functions

var getAllResponses = Promise.all([
  fetch('https://pokeapi.co/api/v2/pokemon/2/')
  .then((response)=>response.json()),
  fetch('https://pokeapi.co/api/v2/pokemon/3/')
  .then((response)=>response.json()),
  fetch('https://pokeapi.co/api/v2/pokemon/4/')
  .then((response)=>response.json()),
])


async function handlePokemons(){
  var allResponses = await Promise.all([
    fetch('https://pokeapi.co/api/v2/pokemon/2/')
    .then((response)=>response.json()),
    fetch('https://pokeapi.co/api/v2/pokemon/3/')
    .then((response)=>response.json()),
    fetch('https://pokeapi.co/api/v2/pokemon/4/')
    .then((response)=>response.json()),
  ]);

  const fetchedPokemons = allResponses
  .filter((response) => responsee.status === 'fulfilled')
  .map((response) => response.value);

  console.log(fetchedPokemons)
}


// Den som blir først ferdig blir resultatet
var getResponses = Promise.race([
  fetch('http//myapi/1/1'),
  fetch('http//myapi/1/2'),
])