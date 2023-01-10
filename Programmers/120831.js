function solution(n) {
    let sum = 0;
    for (let i=2; i<=n; i+=2) {
        sum += i;
    }
    return sum;
    // another solution : 수열공식이용
    // var half = Math.floor(n/2);
    // return half*(half+1);
}
