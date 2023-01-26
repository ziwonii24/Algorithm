function solution(s) {
    const arr = s
    .split(' ')
    .map((a) => a.split('').map((b, i) => {
        if (i === 0) {
            return b.toUpperCase();
        }
        return b.toLowerCase();
    }).join(''));
    return arr.join(' ');
    
    // another solution
    // return s.split(" ").map(v => v.charAt(0).toUpperCase() + v.substring(1).toLowerCase()).join(" ");
}
