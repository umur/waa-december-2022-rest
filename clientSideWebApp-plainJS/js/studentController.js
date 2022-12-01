/**
 * bookController.js
 */

"use strict";

const studentController = (function student() {

    const getAllStudent = async function () {
        try {

            const response = await fetch("http://localhost:8080/students");

            const students = await response.json();
            console.log(students)
            console.log("hello controller");
            return students;


        } catch (error) {

            console.error("not found");
        }

    };

    // const saveBook = async function (newbook) {
    //     try {
    //         const response = await fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/add",
    //             {
    //                 method: "POST", // or 'PUT'
    //                 headers: {
    //                     'Content-Type': 'application/json',
    //                 },
    //                 body: JSON.stringify(newbook),
    //             }
    //         );
    //         const bookAdded = await response.json();
    //         return bookAdded;
    //     } catch (error) {
    //         console.error();
    //     }

    // };

    return {
        getAllStudent: getAllStudent
        // saveBook: saveBook
    }

})();

export { studentController };

