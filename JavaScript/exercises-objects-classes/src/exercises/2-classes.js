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
  constructor(value){
    this.value = value;
    this.startValue = value
  }
  getValue(){
    return this.value;
  };

  increment(){
    this.value++;
  };
  decrement(){
    this.value--
  }
  reset(){
    this.value = this.startValue
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
class Counter2 extends Counter1{
  constructor(value) {
    super(value);
  }
  reset(newValue){
    this.value = newValue
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
class Counter3 extends Counter1{
  constructor(startValue, stepSize) {
    super(startValue);
    this.stepSize = stepSize;
  }
  increment(){
    this.value += this.stepSize;
  };

  decrement(){
    this.value -= this.stepSize;
  };

  reset(newValue){
    this.value = newValue;
  };
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
  constructor(startBalance = 0) {
    this.balance = startBalance
  }
  getBalance(){
    return this.balance;
  };
  deposit(amount){
    this.balance += amount;
  };
  withdraw(amount){
    if (amount<=this.balance){
      this.balance-=amount;
    }
  };

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
class Account2 extends Account1{
  constructor(pin, balance=0) {
    super();
    this.pin = pin
  }
  isPin(pin){
    return pin === this.pin;
  }
  getBalance(pin){
    if (this.isPin(pin)){
      return super.getBalance();
    }
  };
  deposit(amount, pin){
    if (this.isPin(pin)){
      super.deposit(amount);
    }
  }
  withdraw(amount, pin){
    if (this.isPin(pin)){
      super.withdraw(amount);
    }
  };
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
    this.accounts = new Map();
  }
  isPin(pin){
    return this.pin === pin;
  }
  addAccount(type, pin) {
    if (this.isPin(pin)) {
      this.accounts.set(
          type, { name : type, balance : 0 }
      )
    }
  }

  getBalance(type, pin){
    if(this.isPin(pin)) {
      return this.accounts.get(type).balance
    }
  }

  deposit(type, amount, pin){
    if(this.isPin(pin)){
      this.accounts.get(type).balance += amount;
    }
  }

  withdraw(type, amount, pin){
    if(this.isPin(pin)){
      if (this.accounts.get(type).balance>amount)
      this.accounts.get(type).balance -=amount;
    }
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
