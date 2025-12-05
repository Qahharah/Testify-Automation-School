// Challenge 8: Check if a number is divisible by 10

function isDivisibleBy10(number) {
    return number % 10 === 0;
}

// Tests
console.log(isDivisibleBy10(50));   // true
console.log(isDivisibleBy10(23));   // false
console.log(isDivisibleBy10(100));  // true
