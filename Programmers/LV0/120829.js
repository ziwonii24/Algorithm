function solution(angle) {
    return (parseInt(angle / 90) + (!(angle % 90) ? 0 : 0.5)) * 2;
    // another solution
    // return [0, 90, 91, 180].filter(x => angle>=x).length;
}
