// 1-1

function getSecondWord(stringOfWords) {
  var words = stringOfWords.split(' ');

  return words[1] !== undefined ? words[1] : "Not enough words"; // 2 is the third element, 0, 1, 2 ...
}

getSecondWord('hello my good friend');


// 1-2

/* prompt saves a and b as strings.
a = 1, b = 3 --> 13
changing to +prompt(); makes it save prompt as number
a = 1, b = 3 --> 4 */
function addNumbers() {
  var a = +prompt('First number');
  var b = +prompt('Second number');
  var result = a + b;
  console.log(result);
}

addNumbers();


// 1-3
function wordRepeat() {
  var word = prompt('What is your favourite word?')
  var repeat = +prompt('How many times do you want me to repeat it?')
  var output = "";
  for (let i = 0; i < repeat; i++) {
    let joint = ", "
    if (i === repeat - 1) {
      joint = "!"
    }
    output = output + word + joint
  }
  console.log(output);
}

wordRepeat();


// 1-4
function extendString(inputString) {
  var words = inputString.split(" ").length;
  var addToOutput = "";
  if (words > 10) {
    addToOutput = "????"
  } else if (words >= 5) {
    addToOutput = "!!!!"
  }
  console.log(inputString + addToOutput);
}

extendString('Hei abdur, konsentrer deg om checkpointen');

// 1-7

class Counter {
  constructor(a, b) {
    if (a > b) {
      this.roofValue = +a;
      this.floorValue = +b;
    } else {
      this.floorValue = +a;
      this.roofValue = +b;
    }
    this.currentValue = a > b ? +b : +a;
  }

  getValue() {
    return this.currentValue;
  }

  increment() {
    if (this.currentValue < this.roofValue) {
      this.currentValue++
    }
  }

  decrement() {
    if (this.currentValue > this.floorValue) {
      this.currentValue--
    }
  }
}


