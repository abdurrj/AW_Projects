var REPLACE_ME = "...";

var { testCase, assert, assertEquals } = require("../lib/test-runner");

/**
 * DESCRIPTION:
 * Replace all occurrences of 'REPLACE_ME' in the unit tests below to make them
 * all pass (they should be green).
 * HINT
 * If you get stuck, you can replace assert(a == b) with assertEquals(b, a).
 * That way the error message in the browser will be more specific. However,
 * give it a try before you do this, as in most cases this will give you the
 * answer flat out.
 */

testCase("Properties", {
  "Accessing properties": function () {
    var person = {
      name: "Frank",
      age: 33,
      likes: ["Cars", "Flames", "Guitars"],
      car: "Volvo",
      playGuitar: function () {
        return this.name + " plays his guitar";
      },
      driveCar: function () {
        return this.name + " drives his " + this.car + " at the ripe age of " + this.age;
      },
    };

    var someSelectedProperty = "age";

    assert(person.name == "Frank");
    assert(person["name"] == "Frank");
    assert(person[someSelectedProperty] == 33);
    assert(person["car"] == "Volvo");
    assert(person.age == 33);
    assert(person["age"] == 33);
    assert(person.likes.join(", ") == "Cars, Flames, Guitars");
    assert(person.playGuitar() == "Frank plays his guitar");
    assert(person.driveCar() == "Frank drives his Volvo at the ripe age of 33");
  },

  "Accessing properties (2)": function () {
    var hero = {
      name: "Hank",
      items: [{
        type: "weapon",
        name: "Sword of fury",
        color: "red",
      }, {
        type: "food",
        name: "Wild apple",
        color: "green"
      }],
      attacks: [{
        name: "Slash",
        damage: [50, 40, 30]
      }, {
        name: "Hack",
        damage: [75]
      }]
    };

    assert(hero.name == "Hank");
    assert(hero.items[0].type == "weapon");
    assert(hero.items[0].name == "Sword of fury");
    assert(hero.items[0].color == "red");
    assert(hero.items[1].type == "food");
    assert(hero.items[1].name == "Wild apple");
    assert(hero.items[1].color == "green");
    assert(hero.attacks[0].name == "Slash");
    assert(hero.attacks[0].damage[0] == 50);
    assert(hero.attacks[0].damage[1] == 40);
    assert(hero.attacks[0].damage[2] == 30);
    assert(hero.attacks[1].name == "Hack");
    assert(hero.attacks[1].damage[0] == 75);
  },

  "Which properties do I have?": function () {
    var hero = {
      name: "Hank",
      items: [{
        type: "weapon",
        name: "Sword of fury",
        color: "red",
      }, {
        type: "food",
        name: "Wild apple",
        color: "green"
      }],
      attacks: [{
        name: "Slash",
        damage: [50, 40, 30]
      }, {
        name: "Hack",
        damage: [75]
      }]
    };

    var heroProperties = Object.keys(hero);
    var itemProperties = Object.keys(hero.items[0]);
    var attackProperties = Object.keys(hero.attacks[0]);

    assert(heroProperties.join(", ") == "name, items, attacks");
    assert(itemProperties.join(", ") == "type, name, color");
    assert(attackProperties.join(", ") == "name, damage");
  },
});
