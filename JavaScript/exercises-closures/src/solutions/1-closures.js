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

/**
 * 1.
 */
function makeCounter1(initial) {
  var count = initial;

  function reset() {
    count = initial;
  }

  function increment() {
    count++;
  }

  function decrement() {
    count--;
  }

  function getValue() {
    return count;
  }

  return {
    reset: reset,
    increment: increment,
    decrement: decrement,
    getValue: getValue,
  };
}

testCase("makeCounter1", {
  "Works as expected": function () {
    var counter = makeCounter1(10);
    assertEquals(counter.getValue(), 10);
    counter.increment();
    assertEquals(counter.getValue(), 11);
    counter.decrement();
    counter.decrement();
    assertEquals(counter.getValue(), 9);
    counter.reset();
    assertEquals(counter.getValue(), 10);
  },
});

/**
 * 2.
 */
function makeCounter2(initial) {
  var count = initial;

  function reset(toValue) {
    count = toValue;
  }

  function increment() {
    count++;
  }

  function decrement() {
    count--;
  }

  function getValue() {
    return count;
  }

  return {
    reset: reset,
    increment: increment,
    decrement: decrement,
    getValue: getValue,
  };
}

testCase("makeCounter2", {
  "Works as expected": function () {
    var counter = makeCounter2(10);
    assertEquals(counter.getValue(), 10);
    counter.increment();
    assertEquals(counter.getValue(), 11);
    counter.decrement();
    counter.decrement();
    assertEquals(counter.getValue(), 9);
    counter.reset(20);
    assertEquals(counter.getValue(), 20);
  },
});

/**
 * 3.
 */
function makeCounter3(initial, step) {
  var count = initial;

  function reset(toValue) {
    count = toValue;
  }

  function increment() {
    count = count + step;
  }

  function decrement() {
    count = count - step;
  }

  function getValue() {
    return count;
  }

  return {
    reset: reset,
    increment: increment,
    decrement: decrement,
    getValue: getValue,
  };
}

testCase("makeCounter3", {
  "Works as expected": function () {
    var counter = makeCounter3(0, 5);
    assertEquals(counter.getValue(), 0);
    counter.increment();
    assertEquals(counter.getValue(), 5);
    counter.decrement();
    counter.decrement();
    assertEquals(counter.getValue(), -5);
    counter.reset(20);
    assertEquals(counter.getValue(), 20);
  },
});

/**
 * 4.
 */
function createAccount1() {
  var balance = 0;

  function deposit(funds) {
    balance = balance + funds;
  }

  function withdraw(funds) {
    if (balance < funds) {
      console.log("Insufficient funds!");
      return;
    }
    balance = balance - funds;
  }

  function getBalance() {
    return balance;
  }

  return {
    deposit: deposit,
    withdraw: withdraw,
    getBalance: getBalance,
  };
}

testCase("createAccount1", {
  "Works as expected": function () {
    var account = createAccount1();
    assertEquals(account.getBalance(), 0);
    account.deposit(100);
    assertEquals(account.getBalance(), 100);
    account.withdraw(50);
    assertEquals(account.getBalance(), 50);
    account.withdraw(100);
    assertEquals(account.getBalance(), 50);
  },
});

/**
 * 5
 */
function createAccount2(pin) {
  var balance = 0;

  function deposit(funds, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    balance = balance + funds;
  }

  function withdraw(funds, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (balance < funds) {
      console.log("Insufficient funds!");
      return;
    }
    balance = balance - funds;
  }

  function getBalance(enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    return balance;
  }

  return {
    deposit: deposit,
    withdraw: withdraw,
    getBalance: getBalance,
  };
}

testCase("createAccount2", {
  "Works as expected": function () {
    var account = createAccount2("1234");
    assertEquals(account.getBalance("0000"), undefined);
    assertEquals(account.getBalance("1234"), 0);
    account.deposit(100, "0000");
    assertEquals(account.getBalance("1234"), 0);
    account.deposit(100, "1234");
    assertEquals(account.getBalance("1234"), 100);
    account.withdraw(60, "0000");
    assertEquals(account.getBalance("1234"), 100);
    account.withdraw(60, "1234");
    assertEquals(account.getBalance("1234"), 40);
  },
});

/**
 * 6
 */
function createAccounts(pin) {
  var accounts = {};

  function addAccount(name, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    accounts[name] = 0;
  }

  function deposit(name, funds, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    accounts[name] = accounts[name] + funds;
  }

  function withdraw(name, funds, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    if (accounts[name] < funds) {
      console.log("Insufficient funds!");
      return;
    }
    accounts[name] = accounts[name] - funds;
  }

  function getBalance(name, enteredPin) {
    if (enteredPin !== pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    return accounts[name];
  }

  return {
    addAccount: addAccount,
    deposit: deposit,
    withdraw: withdraw,
    getBalance: getBalance,
  };
}

testCase("createAccounts", {
  "Works as expected": function () {
    var accounts = createAccounts("1234");
    accounts.addAccount("savings", "1234");
    assertEquals(accounts.getBalance("savings", "1234"), 0);
    assertEquals(accounts.getBalance("savings", "1234"), 0);
    accounts.deposit("savings", 100, "0000");
    assertEquals(accounts.getBalance("savings", "1234"), 0);
    accounts.deposit("savings", 100, "1234");
    assertEquals(accounts.getBalance("savings", "1234"), 100);
    accounts.withdraw("savings", 60, "0000");
    assertEquals(accounts.getBalance("savings", "1234"), 100);
    accounts.withdraw("savings", 60, "1234");
    assertEquals(accounts.getBalance("savings", "1234"), 40);

    accounts.addAccount("checkings", "1234");
    assertEquals(accounts.getBalance("checkings", "1234"), 0);
    assertEquals(accounts.getBalance("checkings", "1234"), 0);
    accounts.deposit("checkings", 100, "0000");
    assertEquals(accounts.getBalance("checkings", "1234"), 0);
    accounts.deposit("checkings", 100, "1234");
    assertEquals(accounts.getBalance("checkings", "1234"), 100);
    accounts.withdraw("checkings", 60, "0000");
    assertEquals(accounts.getBalance("checkings", "1234"), 100);
    accounts.withdraw("checkings", 60, "1234");
    assertEquals(accounts.getBalance("checkings", "1234"), 40);
  },
});
