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
var REPLACE_ME = "...";

// https://developer.mozilla.org/en-US/docs/Glossary/Hoisting
testCase("Variables", {
  "Declared and initialized variables": function () {
    assert(a == undefined, "Before declaration");

    var a = 42;

    assert(a == 42, "After declaration");
  },
});

// https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/String
testCase("Strings", {
  "typeof result": function () {
    var str = "Welcome to the world of tomorrow!";

    assert(typeof str == "string");
  },

  "Substrings (get a section of the string)": function () {
    var str = "Learning test-driven JavaScript";

    assert(str.slice(9, 20) == "test-driven");
  },

  "String length": function () {
    var str = "Test-driven development";

    assert(str.length == 23, "String length");
    assert(str[str.length] == undefined, "What's at the index?");
  },
});

// https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Boolean
testCase("Booleans", {
  "typeof result": function () {
    var bool = true;

    assert(!bool == false, "==");
    assert(typeof bool == "boolean", "typeof");
  },

  "Converting to booleans": function () {
    var str1 = "A string";
    var str2 = "";

    assert(Boolean(str1) == true, "str1");
    assert(Boolean(str2) == false, "str2");
  },
});

// https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Number
testCase("Numbers", {
  "typeof result": function () {
    var num = 42;

    assert(typeof num == "number");
  },

  "Invalid division": function () {
    var num = 1 / 0;
    assert(num == Infinity, "1 / 0");

    num = 1 / "";
    assert(num == Infinity, '1 / ""');

    num = 1 / {};
    assert(isNaN(num), "1 / {} (ask if stuck!)");
    assert(typeof num == "number", "typeof result");
  },

  "Number conversion": function () {
    var str = "10";
    assert(Number(str) == 10, "Number(10)");

    str = "10.23";
    assert(Number(str) == 10.23, "Number(10.23)");

    str = "10.23";
    assert(parseInt(str) == 10, "parseInt(10.23)");

    str = "10.23";
    assert(parseFloat(str) == 10.23, "parseFloat(10.23)");
  },
});

// https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Math
testCase("Math", {
  "Rounding and PI": function () {
    var num = Math.floor(1337 * Math.PI) / 100;

    assert(num == 42);
  },

  Remainder: function () {
    var num = 42 % 4;

    assert(num == 2);
  },

  "Remainder for array index (bonus)": function () {
    var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    // Without changing the loop predicate;
    // Make sure we never go out of the array's bounds.
    // (Food for thought: What happens if we do go out of bounds?)
    var i = 100;
    while (i--) {
      assert(typeof arr[i % arr.length] == "number");
    }
  }
});

testCase("Null", {
  "Equality and typeof": function () {
    var obj = null;

    assert(obj === null, "===");
    assert(typeof obj == "object", "typeof");
  },
});

testCase("Undefined", {
  "Equality and typeof": function () {
    var obj;

    assert(obj == undefined, "==");
    assert(typeof obj == "undefined", "typeof");
  },
});

// https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array
testCase("Arrays", {
  "Array literals": function () {
    var arr = [1, 2, 3, 4, 5];

    assert(arr.length == 5, "length");
    assert(typeof arr == "object", "typeof");
  },

  "Arrays as strings": function () {
    var arr = ["J", "a", "v", "a", "S", "c", "r", "i", "p", "t"];
    assert(arr.join("") == "JavaScript", "join('')");

    arr = [1, 2, 3];
    assert(arr.join(", ") == "1, 2, 3", "join(', ')");
  },

  "Array slices": function () {
    var arr = "JavaScript".split("");

    assert(arr.slice(4).join("") == "Script");
  },

  "Adding items": function () {
    var arr = [1, 2, 3, 4, 5];
    arr[2] = 0;

    assert(arr.join(", ") == "1, 2, 0, 4, 5");
  },

  "Deleting items": function () {
    var arr = [1, 2, 3, 4, 5];
    delete arr[2];

    assert(arr.length == 5, "length");
    assert(arr.join(", ") == "1, 2, , 4, 5", "join");
  },

  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice
  "Replacing items": function () {
    var arr = [1, 2, 3, 4, 5];
    // Modify array
    // HINT: Modify array using Array.prototype.splice
    arr.splice(2, 1, 0, 0, 0);

    assert(arr.join(", ") == "1, 2, 0, 0, 0, 4, 5");
  },

  "Array constructor": function () {
    var arr = new Array(1, 2, 3, 4, 5);
    assert(arr.join(", ") == "1, 2, 3, 4, 5", "First array");

    arr = Array(1, 2, 3, 4, 5);
    assert(arr.join(", ") == "1, 2, 3, 4, 5", "Second array");

    arr = Array(1, 5);
    assert(arr.join(", ") == "1, 5", "Third array");

    arr = Array(5);
    assert(arr.join(", ") == ", , , , ", "Fourth array");
  },

  "Array item access": function () {
    var arr = [1, 2, 3, 4, 5];

    assert(arr[3] == 4);
  },
});
