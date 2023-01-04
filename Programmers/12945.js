/*
  시간초과..
*/
function solution(n) {
    function fibo(x) {
        if (x === 0) {
            return 0;
        }
        if (x === 1) {
            return 1;
        }
        return fibo(x - 2) + fibo(x - 1);
    }
    return fibo(n) % 1234567;
}
