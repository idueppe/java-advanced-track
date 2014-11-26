/**
 * Created by idueppe on 21.10.14.
 */


var msg = "Hello Node JS.";
console.log(msg);


// Single line comment

/*
 Multi Line comment
 */

var num = 12;
num = 12.3;

var stringWithSingleQuote = 'Dies ist ein String';
var stringWithDoubleQuote = "Dies ist ein String";

console.log(stringWithDoubleQuote === stringWithSingleQuote);

var object = {firstName: 'Ingo', lastName: 'Düppe'};

console.log(object);
console.log(object.firstName + " " + object.lastName);
console.log(typeof object);

var array = [1, 2, 3, 'Ingo', 'Dueppe'];


console.log("Max: " + Math.max(1, 2, 3, 4, 5, 6));
console.log("Zufall: " + Math.random());

console.log(typeof num);
console.log("Ist es eine Zahl? " + !isNaN(num));
console.log("Ist sie unendlich? " + !isFinite(num));

console.log("Ist string endlich? " + isFinite("mmmh"));
console.log("Ist string endlich? " + isFinite(NaN));

var i = 12 / 0; // Infinite
var n = 0 / 0; // NaN
console.log("Ist es eine Zahl? " + !isNaN(n));
console.log("Ist sie unendlich? " + !isFinite(i) + " " + !isNaN(i));


var underflow = Number.MIN_VALUE / 2;

console.log("Underflow MIN_VALUE " + Number.MIN_VALUE);
console.log("Underflow MIN_VALUE / 2 = " + underflow);

console.log("------------------------------------------------  DATEs");

var then = new Date(2014, 9, 21);
var later = new Date(2014, 9, 21, 11, 19, 00);

var now = new Date();
var elapsed = now - then;

console.log(then.toString());
console.log(then.toISOString());
console.log(then.toUTCString());

console.log("Differenz in Millisekunden " + elapsed);

console.log(then.getYear());
console.log(then.getFullYear());

var start = new Date(0);
console.log(start.toISOString());


console.log("-------------------------------------------------- String");

var text = "hello, world";

console.log(text.charAt(0)); // h
console.log(text.charAt(text.length - 1)); // d
console.log(text.substring(1, 4)); // ell
console.log(text.slice(1, 4)); // ell
console.log(text.slice(1, -4)); // ello, w
console.log(text[0]);

console.log(text.replace("h", "H"));


console.log("-------------------------------------------------- Functions");


for (m in console)
    console.log("console." + m + " " + typeof console[m]); // console. m

console['log']("TEXT");
console.log("TEXT");


var out = function (msg) {
    console.log(msg);
}

function log(msg) {
    console.log(msg);
}


out("Funktionsaufruf von out");
log("Funktionsaufruf von log");

var lambda = function (lambda, msg) {
    lambda(msg);
}

lambda(out, "lambda");

// for (initialize; laufbedingung; increment) {...)

for (var i = 0; i < 30; i++) {

}

out("------------------------------------------- ARRAYS")

var numbers = new Array();
out(typeof numbers);

numbers[1] = 123;
numbers[3] = "können auch strings";
numbers[6] = {x: "oder objekte"};

out("Länge  " + numbers.length);
out("n[0] = " + numbers[0]);

numbers.push("Neuer String");
numbers.push({});
numbers.push(124);

out("After Push: " + numbers);

function outObject(object) {
    out("-----")
    for (var p in object) {
        out(p + " | " + (typeof p) + " | " + object[p] + " | " + typeof object[p]);
    }
}

outObject(numbers);
outObject({x: 1, y: 2, z: function () {}});
numbers.halloNeuesAttribute="HIER!";
outObject(numbers);
outArray(numbers);

var obj = {x: 1, y: 2, z: function () {}};
obj[0] = "hello";
obj.length=4;
outArray(obj);

function outArray(array) {
    out("---A-");
    for (var p = 0; p < array.length; p++) {
        out(p + " | " + (typeof p) + " | " + array[p] + " | " + typeof array[p]);
    }
    out("---A-");
}


out("---")
function popoutArray(array) {

    while (array.length > 0)
        out(" > " + array.pop());
}

popoutArray(numbers);


out("After Pop" + numbers);
out("Länge  " + numbers.length);

out ("----------------");

var a = ["","",""];

delete a[1];

out(JSON.stringify(a));
out(a);
out(a.length);
out(a[1] === undefined);
delete a[2];
out(a.length);

a = [1,2,3,4,5,6];

out(a.slice(1,-1));
out(a);
out(a.join("|"));
out(a.reverse());
out(a.sort());
out(a.sort(function(a,b){return b-a;}));
out(a.concat([1,2,3]).sort());

out(a);
a.splice(-4);
out(a + " "+ a.length);


out("hello","welt");





