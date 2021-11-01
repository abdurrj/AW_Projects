var REPLACE_ME = "...";
var REPLACE_ME_TOO = [];

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
  "Accessing properties (1)": function () {
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

    assert(person.name == "Frank", "1");
    assert(person["name"] == "Frank", "2");
    assert(person[someSelectedProperty] == 33, "3");
    assert(person["car"] == "Volvo", "4");
    assert(person.age == 33, "5");
    assert(person["age"] == 33, "6");
    assert(person.likes.join(", ") == "Cars, Flames, Guitars", "7");
    assert(person.playGuitar() == "Frank plays his guitar", "8");
    assert(person.driveCar() == "Frank drives his Volvo at the ripe age of 33", "9");
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

    assert(hero["name"] == "Hank", "1");
    assert(hero["items"][0]["type"] == "weapon", "2");
    assert(hero["items"][0]["name"] == "Sword of fury", "3");
    assert(hero["items"][0]["color"] == "red", "4");
    assert(hero["items"][1]["type"] == "food", "5");
    assert(hero["items"][1]["name"] == "Wild apple", "6");
    assert(hero["items"][1]["color"] == "green", "7");
    assert(hero["attacks"][0]["name"] == "Slash", "8");
    assert(hero["attacks"][0]["damage"][0] == 50, "9");
    assert(hero["attacks"][0]["damage"][1] == 40, "10");
    assert(hero["attacks"][0]["damage"][2] == 30, "11");
    assert(hero["attacks"][1]["name"] == "Hack", "12");
    assert(hero["attacks"][1]["damage"][0] == 75, "13");
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
    var itemProperties = Object.keys(hero["items"][0]);
    var attackProperties = Object.keys(hero["attacks"][0]);

    assert(heroProperties.join(", ") == "name, items, attacks", "1");
    assert(itemProperties.join(", ") == "type, name, color", "2");
    assert(attackProperties.join(", ") == "name, damage", "3");
  },
});
