export function getIdFromUrl(url) {
  return url.split('/')[6];
}

export function getImageFromUrl(url) {
  const id = getIdFromUrl(url);
  return `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png`;
}
