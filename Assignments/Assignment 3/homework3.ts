import * as fs from 'fs';

interface Power {
  name: string;
  cost: number;
  power: number;
}

interface Hero {
  first_name: string;
  last_name: string;
  superpowers: Power[];
  vegan: boolean;
}

// Read JSON file
const rawData = fs.readFileSync('superheroes.json', 'utf8');

// Parse the JSON data
const heroes: Hero[] = JSON.parse(rawData);

// Get all vegan powers
const allVeganPowers = heroes
  .filter(hero => hero.vegan)
  .map(hero => hero.superpowers)
  .reduce((acc, powers) => acc.concat(powers), []);

//add up powers
const totalPowerCost = heroes
  .map(hero => hero.superpowers)
  .reduce((acc, powers) => acc.concat(powers), [])
  .reduce((sum, power) => sum + power.cost, 0);


// Create new JSON object
const result = {
  all_vegan_powers: allVeganPowers,
  total_power_cost: totalPowerCost
};

// Write the result to a new file
fs.writeFileSync('result.json', JSON.stringify(result, null, 2));