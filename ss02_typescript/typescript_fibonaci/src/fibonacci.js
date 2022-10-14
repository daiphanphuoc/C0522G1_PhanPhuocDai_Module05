function fibonacci(n) {
    if (n < 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
var sum = 0;
for (var i = 0; i < 10; i++) {
    var f = fibonacci(i);
    sum += f;
    console.log(f);
}
console.log(sum);
