function solution(dot) {
    if (dot[0] > 0) {
        return dot[1] > 0 ? 1 : 4;
    }
    return dot[1] > 0 ? 2 : 3;
    // another solution1
    // return dot[0] > 0 ? (dot[1] > 0 ? 1 : 4) : (dot[1] > 0 ? 2 : 3);
  
    // another solution2
    /*
    function solution(dot) {
      const [num,num2] = dot;
      const check = num * num2 > 0;
      return num > 0 ? (check ? 1 : 4) : (check ? 3 : 2);
    }
    */
}
