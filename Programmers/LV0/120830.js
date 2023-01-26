function solution(n, k) {
    const free = parseInt(n / 10);
    return n * 12000 + (k - free) * 2000;
    // another solution (~~ : 소숫점 버리기)
    /* 
      function solution(n, k) {
          k-=~~(n/10);
          if (k < 0) k = 0;
          return n*12000+k*2000;
      }
    */
}
