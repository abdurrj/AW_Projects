var { testCase, assert, assertEquals } = require("../lib/test-runner");
var REPLACE_ME = "...";

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
testCase("Variables and scope", {
  "Declare a local variable": function () {
    // Fill in necessary statement(s) to pass the assertions below
    var a = "My first variable";

    assertEquals(a, "My first variable");
    assert(!window.a, "Should not be global");
  },

  "Variables in blocks": function () {
    var language = "JavaScript";

    if (true) {
      var language = "C++";
      // If you're stuck and need more helpful error messages, try:
      // assertEquals(language, REPLACE_ME);
      assert(language == "C++", "Inside the if");
    }

    assert(language == "C++", "Outside the if");
  },

  "Variables in functions (1)": function () {
    var language = "JavaScript";

    function whatLanguage() {
      var language = "C++";

      assert(language == "C++", "In nested function");
    }

    whatLanguage();

    assert(language == "JavaScript", "In outer function");
  },

  "Variables in functions (2)": function () {
    var language = "JavaScript";

    function whatLanguage() {
      language = "C++";

      assert(language == "C++", "In nested function");
    }

    whatLanguage();

    assert(language == "C++", "In outer function");
  },

  "Variables in functions (3)": function () {
    var language = "JavaScript";

    function whatLanguage() {
      language = "C++";

      assert(language == "C++", "In nested function");
    }

    language = "TypeScript";
    whatLanguage();

    assert(language == "C++", "In outer function");
  },
});

testCase("Conditional statements", {
  "If (1)": function () {
    var changeLanguage = false;

    if (changeLanguage) {
      var language = "JavaScript";
    }

    assert(language == undefined);
  },

  "If (2)": function () {
    var changeLanguage = true;

    if (changeLanguage) {
      var language = "JavaScript";
    }

    assert(language == "JavaScript");
  },

  "If (3)": function () {
    var changeLanguage = false;
    var language = "";

    if (changeLanguage) {
      language = "JavaScript";
      language = "TypeScript";
    }

    assert(language == "");
  },

  "If (4)": function () {
    var changeLanguage = true;
    var language = "";

    if (changeLanguage) {
      language = "JavaScript";
      language = "TypeScript";
    }

    assert(language == "TypeScript");
  },

  "If (5)": function () {
    var changeLanguage = false;
    var language = "";

    if (changeLanguage) language = "JavaScript";
    language = "TypeScript";

    assert(language == "TypeScript");
  },

  "If (6)": function () {
    var changeLanguage = true;
    var language = "";

    if (changeLanguage) language = "JavaScript";
    language = "TypeScript";

    assert(language == "TypeScript");
  },

  "Switch / case (1)": function () {
    var language = "JavaScript";
    var result;

    switch (language) {
      case "TypeScript":
        result = 100;
        break;
      case "JavaScript":
        result = 200;
        break;
      case "Python":
        result = 300;
        break;
      default:
        result = 1;
    }

    assert(result == 200);
  },

  "Switch / case (2)": function () {
    var language = "JavaScript";
    var result;

    switch (language) {
      case "TypeScript":
        result = 100;
      case "JavaScript":
        result = 200;
      case "Python":
        result = 300;
      default:
        result = 1;
    }

    assert(result == 1);
  },

  "Switch / case (3)": function () {
    var language = "JavaScript";
    var result;

    switch (language) {
      case "TypeScript":
        result = 100;
      case "JavaScript":
        result = 200;
      case "Python":
        result = 300;
      case "JavaScript":
        result = 900;
    }

    assert(result == 900);
  },

  "Switch / case (4)": function () {
    var language = "JavaScript";
    var result;

    switch (language) {
      case "TypeScript":
        result = 100;
      case "JavaScript":
        result = 200;
      case "Python":
        result = 300;
      case "JavaScript":
        result = 900;
      default:
        result = 1;
    }

    assert(result == 1);
  },

  "Switch / case (5)": function () {
    var language = "JavaScript";
    var result;

    switch (language) {
      case "Type" + "Script":
        result = 100;
        break;
      case "Java" + "Script":
        result = 200;
        break;
      case "Py" + "thon":
        result = 300;
        break;
      default:
        result = 1;
    }

    assert(result == 200);
  },

  "Switch / case (6)": function () {
    var input = 10 + 30;
    var result;

    switch (input) {
      case 20 + 20:
        result = 100;
        break;
      case 14:
        result = 200;
        break;
      case 30 + 10:
        result = 300;
        break;
      default:
        result = 1;
    }

    assert(result == 100);
  },

  "Switch / case (7)": function () {
    var input = 10 + 30;
    var result;

    switch (input) {
      case 20 + 20:
        result = 100;
      case 14:
        result = 200;
      case 30 + 10:
        result = 300;
        break;
      default:
        result = 1;
    }

    assert(result == 300);
  },
});

testCase("while loops", {
  "Should set n = 10 using a loop": function () {
    // Complete the set of statements to pass the assertion
    var n = 0;

    while (n < 10) {
      n++;
    }

    assertEquals(n, 10);
  },

  "Rewrite to use while loop": function () {
    var n = 0;

    while (n < 5) {
      n++;
    }

    assertEquals(n, 5);
  },

  "Strange loop conditional": function () {
    var i = 10,
      n;

    while (i--) {
      n = i;
    }

    assert(n == 0);
  },
});

testCase("for loops", {
  "Should set n = 10 using a loop": function () {
    var n = 0;

    // Complete the loop to pass the assertion
    for (var i = 0; i < 10; ++i) {
      n += 1;
    }

    assertEquals(n, 10);
  },

  "Rewrite to use for loop": function () {
    var result = 1;

    // Complete the loop to pass the assertion
    for (var n = 1; n <= 5; n++) {
      result = result * n;
    }

    assertEquals(result, 120);
    assertEquals(n, 6);
  },
});

testCase("Exceptions", {
  "Make this test pass (catch the error!)": function () {
    try {
      throw new Error("Oops!");
    } catch (e) {}
  },

  "Exception message": function () {
    try {
      throw new Error("Oops!");
    } catch (e) {
      assertEquals(e.message, "Oops!");
      assertEquals(e.name, "Error");
    }
  },

  "Exceptions and scope": function () {
    var e = 42;

    try {
      throw "Oops";
    } catch (e) {
      assert(e == "Oops", "In catch");
    }

    assert(e == 42, "Outside catch");
  },

  "Nested catching": function () {
    var lastError = undefined;

    try {
      throw new Error("Oops!");
    } catch (e) {
      try {
        lastError = e;
        throw new Error("Yikes!");
      } catch (e) {
        lastError = e;
      }
    }

    assert(lastError.message == "Yikes!");
  },
});
