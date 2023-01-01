function solution(arr) {
  //   var answer = 0;
  //   arr.forEach((i) => (answer += i));
  //   answer /= arr.length;
  //   return answer;
  return arr.reduce((a, b) => a + b) / arr.length;
}

console.log(solution([1, 2, 3, 4]));
