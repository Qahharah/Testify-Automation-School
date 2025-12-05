// Challenge 7: Sort numbers in descending order

function sortDescending(numbers) {
    return numbers.sort((a, b) => b - a);
}

// Test
const nums = [10, 3, 25, 7, 100, 42];
console.log(sortDescending(nums));  

// Expected: [100, 42, 25, 10, 7, 3]
