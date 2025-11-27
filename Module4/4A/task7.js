// Step 1: Initialize three variables for the sides of the triangle
let side1 = 5;
let side2 = 5;
let side3 = 5;

// Step 2: Check if all sides are equal (Equilateral triangle)
if (side1 === side2 && side2 === side3) {
    console.log("Equilateral triangle");

// Step 3: Check if any two sides are equal (Isosceles triangle)
} else if (side1 === side2 || side1 === side3 || side2 === side3) {
    console.log("Isosceles triangle");

// Step 4: If none are equal (Scalene triangle)
} else {
    console.log("Scalene triangle");
}
