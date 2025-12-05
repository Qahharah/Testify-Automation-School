// 1. Create an array called books. Each element is a book object.
const books = [
    {
        title: "Ego Is The Enemy",
        description: "A book about overcoming the ego to achieve mastery and purpose",
        numberOfPages: 289,
        author: "Ryan Holiday",
        reading: true
    },
    {
        title: "The Pragmatic Programmer",
        description: "A guide to becoming an effective and adaptable software developer",
        numberOfPages: 352,
        author: "Andrew Hunt and David Thomas",
        reading: false
    },
    {
        title: "Deep Work",
        description: "A book on focus, productivity and the ability to concentrate deeply",
        numberOfPages: 304,
        author: "Cal Newport",
        reading: true
    },
    {
        title: "Atomic Habits",
        description: "A book about building small habits that lead to remarkable results",
        numberOfPages: 288,
        author: "James Clear",
        reading: false
    },
    {
        title: "The Psychology of Money",
        description: "Timeless lessons on wealth, greed and happiness",
        numberOfPages: 256,
        author: "Morgan Housel",
        reading: true
    }
];

// 2. Use a for-loop to log only the books where reading is true.
for (let i = 0; i < books.length; i++) {
    if (books[i].reading === true) {
        console.log(books[i]);
    }
}
