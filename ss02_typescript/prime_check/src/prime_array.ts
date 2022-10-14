function isPrime(n: number): boolean {
    if (n < 2) {
        return false;
    } else {
        for (let i: number = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
    }
    return true;
}

let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sum = 0;
for (let number of array) {
    if (isPrime(number)) {
        sum += number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);