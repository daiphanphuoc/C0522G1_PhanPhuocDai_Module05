let p: number;
p = 2;
let total: number;
total = 0;

for (let i: number = 1; i <= 30; ) {
    let isPrime: boolean = true;
    for (let j: number = 2; j <= Math.sqrt(p); j++) {
        if (p % j == 0) {
            isPrime=false;
            break;
        }
    }
    if(isPrime){
        total+=p;
        i++;
    }
    p++;
}
console.log(total);