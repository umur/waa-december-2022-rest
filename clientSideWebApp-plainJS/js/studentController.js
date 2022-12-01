/**
 * studentController.js
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
//TODO
    // const saveStudent = async function (newStudent) {
    //     try {
    //         const response = await fetch("https://",
    //             {
    //                 method: "POST", // or 'PUT'
    //                 headers: {
    //                     'Content-Type': 'application/json',
    //                 },
    //                 body: JSON.stringify(newStudent),
    //             }
    //         );
    //         const studentAdded = await response.json();
    //         return studentAdded;
    //     } catch (error) {
    //         console.error();
    //     }

    // };

    return {
        getAllStudent: getAllStudent
        //saveStudent: saveStudent
    }

})();

export { studentController };

