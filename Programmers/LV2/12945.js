/*
  시간초과..
*/
function solution(n) {
  // 1. recursive = O(1.6^n)
  //   function fibo(x) {
  //     if (x === 0 || x === 1) {
  //       return x;
  //     }
  //     return fibo(x - 2) + fibo(x - 1);
  //   }

  // 2. recursive + memoization = O(n)
  const MAX_LEN = 100_001;
  let memo = new Array(MAX_LEN).fill(0);
  memo[1] = 1;
  function fibo(x) {
    if (x > 1 && x < MAX_LEN && !memo[x]) {
      memo[x] = (fibo(x - 1) + fibo(x - 2)) % 1234567;
    }
    return memo[x];
  }
  return fibo(n);
}
console.log(solution(5));
// 0 1 1 2 3 5 8 ...
