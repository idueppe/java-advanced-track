/**
 * Created by idueppe on 24.09.14.
 */
"use strict";
function l(msg) {
    console.log(msg)
};

function line() {
    l(new Array(30).join("-"));
}

// Arrays;

// Maximale Index is 2^32-2 4.294.967.294

var empty = [];
var primes = [2, 3, 5, 7, 11];
var misc = [1.1, 2, true, "xxsd", {}, null, undefined];

var md = [
    [1, {}],
    [2, {}],
    [
        [1],
        [
            [5]
        ]
    ]
];
l(md[2][1][0]);

var b = [
    {x: [
        {x: 1},
        {x: 2}
    ]},
    {x: 3}
];
l(b[0].x[1].x);

var undef = [, , , , , ];
l(undef.length);

var a = new Array(); // identisch [];
var b = new Array(20); // identisch zu [,,,,,,,,,,,,,,,,,,]

l(b[24]);
b[24] = "a";
l(b.length);
b[Math.pow(2, 32) - 2] = 1; // ehehe
l(b.length);

//Object.defineProperty(b, "length", {writable: false});

b.length = 0;
l(b.length);
l(b[24]);

var a = [1, 2, 3, 2];
a.push("zero");
a.push("one", "two");
l(a);

delete a[1];
l(a);
l(1 in a); // existiert der Index 1
l(2 in a); // existiert der Index 2
l(a.length);

a.name = "mein spezielles array";

l(a);

l("-------------")
for (var p in a)
    l(p + "=" + a[p]);

l("--------------------")

var obj = {a: 1, name: "2", done: true, func: function () {
    return "..."
}};
for (var p in obj)
    if (typeof obj[p] == "function")
        l(p + "=" + obj[p]());
    else
        l(p + "=" + obj[p]);


l("-----------------------------");
for (var i = 0; i < a.length; i++)
    l(a[i]);

l("-----------------------------");
var data = [1, 2, 3, 4, 5];
var sumOfSquares = 0;
data.forEach(function (x) {
    sumOfSquares += x * x;
});
l(sumOfSquares);


l("-----------------------------");
var a = [1,2,3];
l(a.join());
l(a.join(" "));
l(typeof a.join(" "));
l(a.join(""));
var b = new Array(10);
l(b.join("-"));
l(new Array(30).join("-"));

l(a.reverse().join());

var x = [3,1,2];
l(x);
l(x.sort(function(a,b){return b-a}));
l(x.sort(function(a,b){return a-b}));

l(a.concat(x));

line();

var a = [1,2,3,4];

l(a);
a.unshift(4,3,2);
l(a);

line();

var map = {};

map["Ingo"]="Düppe";
for (var p in map)
  if ("Ingo" in map)
    l(p+"="+map[p]);
