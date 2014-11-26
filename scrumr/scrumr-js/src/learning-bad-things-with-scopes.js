/**
 * Created by idueppe on 21.10.14.
 */

function out (msg) {
    console.log(msg);
}

scopeA = "global";
function checkScopeA() {
    // hoisting var scopeA;
    out(scopeA);                // undefined
    var scopeA = "local";
    out(scopeA);                // local
    return scopeA;              // local
}

out("Result "+checkScopeA());   // local
out("ScopeA "+scopeA);          // global

out("----------- NESTED ---------------");

var scopeB = "global";
function checkScopeB() {
    var scopeB = "local";
    function nested() {
        return scopeB;
    }
    return nested();
}

out(checkScopeB());

out("-----------------------------------");

function test(o) {
    out("k=" + k);
    out("j=" + j);
    out("i=" + i);
    var i = 0;
    if (typeof o == "object") {
        var j = 0;
        for (var k = 0; k < 3; k++) {
            out("k=" + k);
        }
        out("k=" + k);
    }
    out("k=" + k);
    out("j=" + j);
    out("i=" + i);
    return i + j + k;
}

out("result w object  = "+test({a:"xxx"}));
out("result w/o object = "+test(1));

out("-----------------------------");

var scopeC = "global";

function checkScopeNested() {
    out(scopeC);
}

function checkScopeC() {
    var scopeC = "local";
    checkScopeNested();
}

checkScopeC();

out("-----------------------------");

var functions = [];

for (var i = 0; i < 10 ; i++) {
    functions.push(function() {
        out("i="+i);
    })
}
functions.forEach(function(func) {
    func();
});