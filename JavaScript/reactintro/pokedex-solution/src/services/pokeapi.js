import axios from 'axios';

import { getIdFromUrl, getImageFromUrl } from '../utils/pokemon';

export function fetchPokemonTypes() {
  return axios.get('https://pokeapi.co/api/v2/type')
  .then(({ data }) => data.results)
  .then((types) => {
    return types.map((type) => {
      return {
        ...type,
        id: +getIdFromUrl(type.url),
      };
    });
  });
}

export function fetchAllPokemons() {
  return axios.get('https://pokeapi.co/api/v2/pokemon', {
    params: {
      limit: 807,
    }
  })
  .then(({ data }) => data.results)
  .then((pokemons) => {
    return pokemons.map((pokemon) => {
      return {
        ...pokemon,
        id: +getIdFromUrl(pokemon.url),
        image: getImageFromUrl(pokemon.url),
      };
    });
  });
}

export function fetchPokemonsByType(type) {
  return axios.get(`https://pokeapi.co/api/v2/type/${type}`, {
    params: {

    }
  })
  .then(({ data }) => data.pokemon)
  .then((pokemons) => {
    return pokemons.map(({ pokemon }) => {
      return {
        ...pokemon,
        id: +getIdFromUrl(pokemon.url),
        image: getImageFromUrl(pokemon.url),
      };
    });
  });
}

export function fetchPokemonById(id) {
  return axios.get(`https://pokeapi.co/api/v2/pokemon/${id}`, {
    params: {

    }
  })
  .then(({ data }) => data)
  .then((pokemon) => {
    return {
      ...pokemon,
      images: [
        pokemon.sprites.back_default,
        pokemon.sprites.back_shiny,
        pokemon.sprites.front_default,
        pokemon.sprites.front_shiny,
      ],
    }
  });
}
