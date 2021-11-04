// 2-1

/*function padString(str, pad, len) {
  var outputString = ""

  if (pad !== "" && len !== 0) {
    for (var i = 0; i < len; i++) {
      outputString = outputString + pad;
    }
  }

  return outputString + str;
}*/

// 2-2

/*const families = [
    {
        father: 'John',
        mother: 'Mary',
        children: ['Frank']
    },
    {
        father: 'Mark',
        mother: 'Linda',
        children: ['Billy', 'Nina']
    },
    {
        father: 'Chris',
        mother: 'Lisa',
        children: ['Dolly', 'Richard', 'Eva']
    },
    {
        father: 'Herbert',
        mother: 'Ursula',
        children: ['Eleanor', 'Joshua', 'James']
    }
];


var nameOfChildren = families.reduce(function(children, family) {
    return children.concat(family.children);
},[]);

var kidsNamesUppercaseIfManyKids = families
  .filter(f => f.children.length>2)
  .reduce(function(children, family) {
      return children.concat(family.children);
  },[])
  .map(o => o.toUpperCase());*/


// 2-3
/*
function createCounter(a, b) {
    var floorValue = 0;
    var roofValue = 0;

    if (a > b){
        roofValue = +a;
        floorValue = +b;
    }
    else{
        floorValue = +a;
        roofValue = +b;
    }
    var currentValue = a>b ? +b : +a;

    return {
        getValue : function() { return currentValue; },
        increment: function() { currentValue<roofValue ? currentValue++ : currentValue },
        decrement : function() { currentValue>floorValue ? currentValue-- : currentValue},
    }
}
*/

// 2-4

