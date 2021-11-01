var { testCase, assert, assertEquals } = require("../lib/test-runner");

/**
 * DESCRIPTION:
 * Replace all occurrences of 'REPLACE_ME' in the unit tests below to make them
 * all pass (they should be green).
 * Also - replace all occurences of TRUE_OR_FALSE with either the boolean
 * value of "true" or "false" to make them all pass (they should be green)
 * HINT
 * If you get stuck, you can replace assert(a == b) with assertEquals(b, a).
 * That way the error message in the browser will be more specific. However,
 * give it a try before you do this, as in most cases this will give you the
 * answer flat out.
 */
var REPLACE_ME = "...";
var TRUE_OR_FALSE = "...";

testCase("Truthy and falsy values", {
  "Name all falsy values": function () {
    // Use each falsy value only once! :)
    assert(!false);
    assert(!undefined);
    assert(!NaN);
    assert(!"");
    assert(!null);
    assert(!0);
  },

  "Which branch is executed?": function () {
    var value, result;

    if (value) {
      result = true;
    } else {
      result = false;
    }

    assert(result == false);
  },

  "Truth value of string zero": function () {
    var value = "0";

    assert(value == false);
  },

  "Falsy loop termination": function () {
    var result1 = [],
      result2 = [];
    var i = 5;

    while (--i) {
      result1.push(i);
    }

    i = 5;

    while (i--) {
      result2.push(i);
    }

    assert(result1.join(", ") == "4, 3, 2, 1", "result1");
    assert(result2.join(", ") == "4, 3, 2, 1, 0", "result2");
  },

  "Using logical and on strings": function () {
    var name = "Eirik";
    var job = "Programmer";

    assert((name && job) == job);
  },

  "Unary not operator and strings": function () {
    var name = "Eirik";

    assert(!name == false);
  },
});

testCase("Equality", {
  "Comparing undefined": function () {
    var result = undefined == undefined;

    assert(result == true);
  },

  "Comparing null": function () {
    var result = null == null;

    assert(result == true);
  },

  "Comparing null with undefined": function () {
    var result1 = null == undefined;
    var result2 = undefined == null;

    assert(result1 == true, "result1");
    assert(result2 == true, "result2");
  },

  "Comparing NaN": function () {
    var result = NaN == NaN;

    assert(result == false);
  },

  "Comparing arrays": function () {
    var arr1 = [1, 2, 3, 4, 5];
    var arr2 = [1, 2, 3, 4, 5];
    var compareToSelf = arr1 == arr1;
    var compareToOther = arr1 == arr2;

    assert(compareToSelf == true, "compare to self");
    assert(compareToOther == false, "compare to other");
  },
});

testCase("Coercion", {
  "Comparing strings and numbers": function () {
    var string = "3";
    var number = 3;
    var result = string == number;

    assert(result == true);
  },

  "Comparing booleans to strings": function () {
    var bool = true;
    var string = "1";
    var result = bool == string;

    assert(result == true);
  },

  "Boolean arithmetic": function () {
    var result = (true + true) * (true + true) + false;

    assert(result == 4);
  },
});

testCase("Addition or concatenation?", {
  "Adding string and number": function () {
    var str = "42";
    var num = 42;

    assert(str + num == "4242");
  },

  "Adding string and boolean": function () {
    var str = "42";
    var bool = true;

    assert(str + bool == "42true");
  },

  "Adding number and boolean": function () {
    var number = 42;
    var bool = true;

    assert(number + bool == 43);
  },

  "Applying unary plus before addition/concatenation": function () {
    var string = "42";
    var number = 42;

    assert(+string + number == 84);
  },
});

testCase("Strict equality", {
  "Comparing numbers": function () {
    var result = 42 === 42;

    assert(result == true);
  },

  "Comparing strings": function () {
    var result = "Eirik" === "Eirik";

    assert(result == true);
  },

  "Comparing objects": function () {
    var object = { course: "JavaScript for Developers" };
    var result = object === { course: "JavaScript for Developers" };

    assert(result == false, "result");
  },
});

testCase("Short-circuiting expressions", {
  "&&": function () {
    var lang = { name: "JavaScript" };
    var version = lang && lang.name && lang.version;

    assert(version == lang.version);
  },

  "||": function () {
    var lang = { name: "JavaScript", version: "1.8" };
    var version = (lang && lang.version) || "1.5";

    assert(version == (lang && lang.version));
  },

  "Greedy || (bonus)": function () {
    function addClassName(el, className) {
      if (!el || !el.className) {
        return;
      }

      el.className += " " + className;
    }

    var el = { className: "" };
    addClassName(el, "awesome");

    assertEquals(el.className, "");
  },

  "Working addClassName (bonus)": function () {
    function addClassName(el, className) {
      // Implement the function so the assertions pass
      // (You can use the previous exercises as your starting point)

      // empty string is "" -> false
      // if (!"")--> if(true)
      if (!el || typeof el.className != "string") {
        return;
      }
      el.className +=  " " + className;
    }

    var el = { className: "" };
    addClassName(el, "item");
    assertEquals(el.className, " item");

    var el2 = {};
    addClassName(el2, "line");
    assert(el2.className == null, "el2");
  },
});
