function solution(n) {
    let sum=0;
    for(let i=0; i<=n; i+=1) {
        if(n%i===0) {
            sum += i;
        }
    }
    return sum;
}
