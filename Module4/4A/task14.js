
const books = {
    title: "Ego Is the Enemy",
    description: "A powerful book about overcoming the biggest obstacle to success and growth which is our own ego.",
    numberOfPages: 256,
    author: "Ryan Holiday",
    reading: true,

    toggleReadingStatus: function () {
        this.reading = !this.reading;  
        console.log(this.reading);
    }
};

// Call the method to test
books.toggleReadingStatus();
