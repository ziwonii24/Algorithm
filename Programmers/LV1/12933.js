function solution(n) {
  return +(n.toString().split('').sort().reverse().join(''));
}
