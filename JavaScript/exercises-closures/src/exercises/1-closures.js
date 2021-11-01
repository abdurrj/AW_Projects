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
 * 1. (See slides for description)
 */
function makeCounter1(initial) {
  var value = initial

  return {
    getValue : function() { return value; },
    increment: function() { value++ },
  decrement : function() { value-- },
  reset : function() { value = initial }
}

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
 * 2. (See slides for description)
 */
function makeCounter2(initial) {
  var value = initial

  return {
    getValue : function(){ return value },
    increment  : function (){value++},
    decrement  : function (){value--},
    reset : function(newValue){value = newValue}
  }
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
 * 3. (See slides for description)
 */
function makeCounter3(initial, step) {
  var value = initial;
  var step = step

  return {
    getValue : function(){return value},
    increment : function(){value+=step},
    decrement : function(){value-=step},
    reset : function(newValue){value = newValue}
  }
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
 * 4. (See slides for description)
 */
function createAccount1() {
  var balance = 0;
  return {
    getBalance : function(){return balance},
    deposit : function(amount){balance += amount},
    withdraw : function(amount){
      if (balance >= amount){
        balance-=amount
      }
    }
  }
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
 * 5. (See slides for description)
 */
function createAccount2(pin) {
  var balance = 0;
  var accountPin = pin;
  function checkPin(pin){
    return pin===accountPin
  }

  return {
    getBalance : function(pin){if (checkPin(pin)) return balance},
    deposit : function(amount, pin){if (checkPin(pin)) balance+=amount},
    withdraw : function(amount, pin){
      if (checkPin(pin)){
        if (balance>=amount){
          balance-=amount
        }
      }
    }
  }
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
 * 6. (See slides for description)
 */
function createAccounts(pin) {
  var accountPin = pin
  var accounts = new Map();
  function isPin(pin){
    return accountPin === pin;
  }
  return {
    addAccount : function(name, pin){
      if (isPin(pin)){
        accounts.set(name, {name : name, balance :0});
      }
    },
    getBalance : function(name, pin){
      if (isPin(pin)){
        return accounts.get(name).balance;
      }
    },
    deposit : function(name, amount, pin){
      if (isPin(pin)){
        accounts.get(name).balance+=amount;
      }
    },
    withdraw : function(name, amount, pin){
      if (isPin(pin)){
        var account = accounts.get(name);
        if(account.balance>=amount){
          account.balance-=amount;
        }
      }
    }
  }
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
