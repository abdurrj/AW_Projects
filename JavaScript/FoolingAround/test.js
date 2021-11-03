console.log("hello");

for (let i = 0; i<10; i++){
    console.log(i);
}


var testFunction = function doSomething(str="hellooo"){
    stringArray = str.split("");
    for (let i = 0; i<stringArray.length; i++){
        console.log(stringArray[i])
    }
}


testFunction();