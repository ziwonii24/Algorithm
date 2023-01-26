/*
 stack에 (만 쌓고 )를 만나면 하나씩 빼내었다
 빼낼때 없으면 틀린거고 마지막에 하나이상 남아도 틀린거!
 근데 진짜 stack으로 안하고 그냥 카운트만 셌어도 됐겠다..
*/
function solution(s){
    var answer = true;
    const stack = [];
    s.split('').forEach((c) => {
        if (c === '(') {
            stack.push(c);
            return;
        }
        if (c === ')' && stack.length) {
            stack.pop();
            return;
        }
        answer = false;
    })
    if (answer && stack.length) {
        answer = false;
    }
    return answer;
}
