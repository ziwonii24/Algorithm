function solution(x, n) {
    const answer = [];
    if (!x) {
        return new Array(n).fill(x)
    }
    const abs = Math.abs(x);
    for(let i=abs; i<=abs*n; i+=abs) {
        if (abs !== x) answer.push(-i)
        else answer.push(i)
    }
    return answer;
    // another solution
    // return new Array(n).fill(x).map((v, i) => (i + 1) * v);
}
