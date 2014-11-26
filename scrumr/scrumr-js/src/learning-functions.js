/**
 * Created by idueppe on 21.10.14.
 */

function sum(n) {
    var total = 0;
    for (var i = 0; i < arguments.length; i++)
    {
        var element = arguments[i];

        if (element == null) continue;
        if (Array.isArray(element))
            n = sum.apply(this, element);
        else if (typeof element === "function")
            n = Number(element());
        else
            n = Number(element);
        if (isNaN(n))
            throw Error("sum(): can't covnert "+element+" to a number");

        total += n;
    }
    return total;
}

console.log(sum(1,2,[3,6,2],"2",4));