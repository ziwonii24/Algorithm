function solution(a, b) {
    let sum = 0;
    for(let i=Math.min(a, b); i<=Math.max(a, b); i+=1) {
        sum += i;
    }
    return sum;
    
    // another solution
    // 가우스의 덧셈 공식 활용 : ( a + b ) *  ( b - a + 1) * 1/2 
    return (a+b)*(Math.abs(b-a)+1)/2
}
