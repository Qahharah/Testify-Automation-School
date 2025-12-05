function sumArray(numbers) {
    let sum = 0;

    for (let i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }

    return sum;
}

// Test
const myNumbers = [10, 20, 30, 40, 50, 60];
console.log(sumArray(myNumbers)); 
// Output: 210
