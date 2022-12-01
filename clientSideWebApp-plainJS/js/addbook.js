/**
 * app.js
 */

"use strict";

import { bookController } from "./studentController.js";

document.addEventListener("DOMContentLoaded", () => {

    const bookForm = document.getElementById("bookForm");
    const txttitle = document.getElementById("title");
    const txtisbn = document.getElementById("isbn");
    const txtoverdueFee = document.getElementById("overdueFee");
    const txtpublisher = document.getElementById("publisher");
    const txtdatePublished = document.getElementById("datePublished");
    //fetch book data always use try catch
    bookForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        const newBook = {
            "isbn": txtisbn.value,
            "title": txttitle.value,
            "overdueFee": txtoverdueFee.value,
            "publisher": txtpublisher.value,
            "datePublished": txtdatePublished.value

        };

        try {
            const bookAdded = await bookController.saveBook(newBook);
            console.log(bookAdded);
        } catch (error) {
            console.error();
        }

        document.location = "./book-list.html"

    })


});
