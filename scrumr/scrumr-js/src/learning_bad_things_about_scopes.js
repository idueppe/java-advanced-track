/**
 * Created by idueppe on 24.09.14.
 */

function out(msg) {
    console.log(msg)
};

scopeA = "global";
function checkScopeA() {
    // var scopeA;
    out(scopeA);
    var scopeA = "local"; // scopeA = "local"
    out(scopeA);
    return scopeA;
}
out("Result=" + checkScopeA());
out("ScopeA=" + scopeA);

// nested
out("-----------------------------");

var scopeB = "global";
function checkScopeB() {
//    var scopeB = "local scope";
    function nested() {
//        var scopeB = "nested scope";
        return scopeB;
    }

    return nested();
}
out("Nested:" + checkScopeB());

out("-----------------------------");

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

var functions = [];

for (var i = 0; i < 10 ; i++) {
    functions.push(function() {
        out("i="+i);
    })
}
functions.forEach(function(func) {
    func();
});

