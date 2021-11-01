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
class Counter1 {
  constructor(initial) {
    this.initial = initial;
    this.count = initial;
  }

  reset() {
    this.count = this.initial;
  }

  increment() {
    this.count++;
  }

  decrement() {
    this.count--;
  }

  getValue() {
    return this.count;
  }
}

testCase("Counter1", {
  "Works as expected": function () {
    var counter = new Counter1(10);
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
class Counter2 {
  constructor(initial) {
    this.count = initial;
  }

  reset(toValue) {
    this.count = toValue;
  }

  increment() {
    this.count++;
  }

  decrement() {
    this.count--;
  }

  getValue() {
    return this.count;
  }
}

testCase("Counter2", {
  "Works as expected": function () {
    var counter = new Counter2(10);
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
class Counter3 {
  constructor(initial, step) {
    this.initial = initial;
    this.step = step;
    this.count = initial;
  }

  reset(toValue) {
    this.count = toValue;
  }

  increment() {
    this.count = this.count + this.step;
  }

  decrement() {
    this.count = this.count - this.step;
  }

  getValue() {
    return this.count;
  }
}

testCase("Counter3", {
  "Works as expected": function () {
    var counter = new Counter3(0, 5);
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
class Account1 {
  constructor() {
    this.balance = 0;
  }

  deposit(funds) {
    this.balance = this.balance + funds;
  }

  withdraw(funds) {
    if (this.balance < funds) {
      console.log("Insufficient funds!");
      return;
    }
    this.balance = this.balance - funds;
  }

  getBalance() {
    return this.balance;
  }
}

testCase("Account1", {
  "Works as expected": function () {
    var account = new Account1();
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
class Account2 {
  constructor(pin) {
    this.pin = pin;
    this.balance = 0;
  }

  deposit(funds, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    this.balance = this.balance + funds;
  }

  withdraw(funds, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (this.balance < funds) {
      console.log("Insufficient funds!");
      return;
    }
    this.balance = this.balance - funds;
  }

  getBalance(enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    return this.balance;
  }
}

testCase("Account2", {
  "Works as expected": function () {
    var account = new Account2("1234");
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
class Accounts {
  constructor(pin) {
    this.pin = pin;
    this.accounts = {};
  }

  addAccount(name, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    this.accounts[name] = 0;
  }

  deposit(name, funds, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof this.accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    this.accounts[name] = this.accounts[name] + funds;
  }

  withdraw(name, funds, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof this.accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    if (this.accounts[name] < funds) {
      console.log("Insufficient funds!");
      return;
    }
    this.accounts[name] = this.accounts[name] - funds;
  }

  getBalance(name, enteredPin) {
    if (enteredPin !== this.pin) {
      console.log("Wrong pin code!");
      return;
    }
    if (typeof this.accounts[name] === "undefined") {
      console.log("Account does not exist");
      return;
    }
    return this.accounts[name];
  }
}

testCase("Accounts", {
  "Works as expected": function () {
    var accounts = new Accounts("1234");
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
