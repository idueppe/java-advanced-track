"use strict";
// JAVASCRIPT LITERALS
var num = 12; // Number Floating
var num2 = 1.2; // Number Floating

console.log(num);
console.log(num2);

var str1 = 'String with single quote';
var str2 = "String with double quote";

var truthy = true;
var falsy = false;

var pattern = /javascript/; // <- Regulärer Ausdruck!!

console.log(pattern.test("java"));
console.log(pattern.test("javascript"));

var obj = { x: 1, y: 2, z: undefined, v: null};
console.log(obj.x);
console.log("obj as JSON " + JSON.stringify(obj));

obj.newProperty = "Neue Eigenschaft";

console.log("obj as JSON " + JSON.stringify(obj));

// /* var */ x = 1+2; // auf globaler Ebene kein Unterschied
// klappt nicht mit "use strict";
// y = x;
// console.log(y);

console.log(0xff);

console.log(Math.PI);


// Numbers

var undendlich = Infinity;

var positivUnendlich = Number.POSITIVE_INFINITY;

var infinitNumber = 10 / 0;

console.log(isNaN(infinitNumber));
console.log("10 / 0 is infinite ? " + !isFinite(infinitNumber));

console.log("10/0 == NaN " + isNaN(10 / 0));
console.log("0/0 == NaN " + isNaN(0 / 0));

// Dates

var then = new Date(2014, 9, 24);
var later = new Date(2014, 9, 24, 10, 57, 0);
var now = new Date();

var elapsed = later - then;

console.log(then);
console.log(later);
console.log(now);
console.log(elapsed);

console.log(then == "Fri Oct 24 2014 00:00:00 GMT+0200 (CEST)");
var date = new Date("Fri Oct 24 2014 00:00:00 GMT+0200 (CEST)");
console.log(then.getDate() == date.getDate());
console.log(then == date); // mmmh ???
console.log(typeof then.getDate());
console.log(then === "Fri Oct 24 2014 00:00:00 GMT+0200 (CEST)");

// Strings

var strWithEscapes = 'You\'re right!';
console.log(strWithEscapes);

strWithEscapes.charAt(0);
var s = strWithEscapes.toUpperCase();
console.log(s);

console.log(s[1]); // statt charAt() einfach [];

// Pattern Matching
console.log("------------------------------");

var text = "testing: 1,2,3";
var textNotMatching = "testing";

var pattern = /\d+/g;
console.log(pattern.test(text));
console.log(pattern.test(textNotMatching));
console.log(text.search(pattern));
console.log(text[text.search(pattern)]);
console.log(text.match(pattern));
console.log(text.replace(pattern, 'TEXT'));
console.log(text.split(/\D+/));

// Boolesche Ausdrücke
var a = 5;
var b = 1;
if (a == 5)
    b = b + 1;
else
    a = a + 1;

// false : undefined, null, 0, -0, NaN, ""

a = 0;
if (!a)
    console.log("0 is false");


// Type Conversions

console.log(typeof (Number("3")));
console.log(typeof (String(false)));
console.log(typeof (Boolean([])));
console.log(typeof (Object(3)));
console.log(JSON.stringify(Object(3)));


var point = {x: 1, y: 2}.toString();
console.log("Object toString " + point);
point = {x: 1, y: 2}.toString();

// functions
console.log("---------------------------------")

var func = function (parameter) {
    console.log("--" + parameter);
    return "something";
};

console.log(func);
console.log("Typeof Func" + typeof func);
console.log(" " + func("xxx"));
console.log(" " + func(null));

function square(x) {
    return x * x;
}

var area = {
    width: 5,
    height: 10,
    space: function () {
        return this.width * this.height;
    }
}


console.log(area.space());
area.width = 6;
console.log(area.space());
console.log(JSON.stringify(area))


//console.log(square(5));

var add = function (a, b) {
    var f = function (c) {
        return a+c;
    }
    return b(a)+f(a);
}

console.log(add(4, function (x) {
    return x + 4
}));


// LOOP

for (var i = 0; i < 10; i++) {
    console.log(i);
}






























