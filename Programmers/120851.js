function solution(my_string) {
    let sum = 0;
    [...my_string].forEach((c) => {
        if (+c) {
            sum += +c;
        }
    })
    return sum;
    // another solution
    // return my_string.replace(/[^0-9]/g, '').split('').reduce((acc, cur) => acc + Number(cur), 0);
}
