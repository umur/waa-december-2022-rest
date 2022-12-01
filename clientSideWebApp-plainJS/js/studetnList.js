/**
 * app.js
 */

"use strict";

import { studentController } from "./studentController.js";

document.addEventListener("DOMContentLoaded", () => {

    const tbodyStudentList = document.getElementById("tbodyStudentList");
    console.log(tbodyStudentList);
    //fetch book data always use try catch
    async function displayStudent() {
        const student = await studentController.getAllStudent();
        // console.log(student);

        for (let [index, val] of student.entries()) {
            let course = "";
            for (let i = 0; i < val.coursesTaken.length; i++) {
                course += `<li>${val.coursesTaken[i].name}</li>`

            }
            tbodyStudentList.innerHTML += `
                                        <tr>
                                            <td>${index + 1}</td>
                                            <td>${val.firstName} ${val.lastName}</td>
                                            <td>${val.email}</td>
                                            <td>${val.major}</td>
                                            <td><ol>${course}</ol></td>
                                           
                                        </tr>
                                        `;
        };

    }
    displayStudent();
});
