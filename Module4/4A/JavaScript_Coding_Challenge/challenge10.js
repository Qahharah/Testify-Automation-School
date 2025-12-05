// Challenge 7: Filter out negative numbers

function filterNegativeNumbers(arr) {
    let result = [];

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] >= 0) {
            result.push(arr[i]);
        }
    }

    return result;
}

// Test
const numbers = [-5, 10, -3, 20, 0, -1, 15];
console.log(filterNegativeNumbers(numbers));
// Expected output: [10, 20, 0, 15]
