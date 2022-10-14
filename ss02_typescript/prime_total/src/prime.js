var p;
p = 2;
var total;
total = 0;
for (var i = 1; i <= 30;) {
    var isPrime = true;
    for (var j = 2; j <= Math.sqrt(p); j++) {
        if (p % j == 0) {
            isPrime = false;
        }
    }
    if (isPrime) {
        total += p;
        i++;
    }
    p++;
}
console.log(total);
