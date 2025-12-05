function manualSort(arr) {
    let sorted = arr.slice();

    for (let i = 0; i < sorted.length; i++) {
        for (let j = i + 1; j < sorted.length; j++) {
            if (sorted[j] < sorted[i]) {
                let temp = sorted[i];
                sorted[i] = sorted[j];
                sorted[j] = temp;
            }
        }
    }

    return sorted;
}

console.log(manualSort([3, 1, 4, 2]));
// Expected: [1, 2, 3, 4]
