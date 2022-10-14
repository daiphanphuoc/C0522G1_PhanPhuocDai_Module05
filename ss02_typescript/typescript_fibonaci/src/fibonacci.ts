function fibonacci(n: number): number {
    if (n < 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

let sum: number = 0;
for (let i: number = 0; i < 10; i++) {
    let f: number = fibonacci(i);
    sum += f;
    console.log(f);
}
console.log(sum);