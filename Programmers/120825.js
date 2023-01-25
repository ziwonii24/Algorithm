function solution(my_string, n) {
    const answer = [];
    my_string.split('').forEach((c) => {
        answer.push(c.repeat(n));
    });
    return answer.join('');
    // another solution
    // return [...my_string].map((c) => c.repeat(n)).join('');
}
