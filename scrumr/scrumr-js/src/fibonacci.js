/**
 * Created by idueppe on 21.10.14.
 */

/*
    f(0) = 0;
    f(1) = 1;
    f(2) = 1;
    f(n) = f(n-1) + f(n-2)

    Fibonacci Zahlen von f(1) .. f(1480) rückwärts ausgeben.
 */

var fibs = [0,1];

var fibonacci = function(n)
{
//    if (fibs[n] == undefined)
    if (isNaN(n))
        return NaN;
    if (! (n in fibs))
        fibs[n] = fibonacci(n-2) + fibonacci(n-1);
    return fibs[n];
//    if (n == 0) return 0;
//    if (n == 1) return 1;
//    if (n == 2) return 1;
//    return fibonacci(n-2) + fibonacci(n-1);
};


fibonacci(1500);
console.log()
console.log(fibs.reverse());


