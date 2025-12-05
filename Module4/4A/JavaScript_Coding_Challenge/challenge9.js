function removeDuplicates(arr) {
    let unique = [];

    for (let i = 0; i < arr.length; i++) {
        if (unique.indexOf(arr[i]) === -1) {
            unique.push(arr[i]);
        }
    }

    return unique;
}

console.log(removeDuplicates([10, 20, 20, 30, 40, 40]));

// Expected: [10, 20, 30, 40]
