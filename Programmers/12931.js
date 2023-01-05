function solution(n)
{
    return n.toString().split('').reduce((acc, cur) => +acc + +cur, 0);
}
