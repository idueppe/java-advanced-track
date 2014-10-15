/**
 * Created by idueppe on 24.09.14.
 */
var fibCache = {0: 0, 1: 1};

function fibonacci(n) {
    if (isNaN(n))
        return NaN;
    else if (n in fibCache)
        return fibCache[n];
//    else if (n == 0)
//        return 0;
//    else if (n == 1)
//        return 1;
    else {
        fibCache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fibCache[n];
    }

}

for (var n = 0; n <= 1500; n++)
    fibonacci(n);

for (var n in fibCache) {
    console.log(n + "=" + fibCache[n]);
}

