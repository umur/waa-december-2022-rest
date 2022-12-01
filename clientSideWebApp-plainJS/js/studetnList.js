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
            //courseTaken ="";
            let course = "";
            let space = ",";

            const courses = JSON.stringify(val.coursesTaken);

            console.log("===" + courses);
            for (let i = 0; i < val.coursesTaken.length; i++) {
                course += `<li>${val.coursesTaken[i].name}</li>`

            }



            tbodyStudentList.innerHTML += `
                                        <tr>
                                            <td scope="col">${index + 1}</td>
                                            <td scope="col">${val.firstName} ${val.lastName}</td>
                                            <td scope="col">${val.email}</td>
                                            <td scope="col">${val.major}</td>
                                            <td scope="col"><ol>${course}</ol></td>
                                           
                                        </tr>
                                        `;
        };
        // for (let index = 0; index < book.length; index++) {
        //     let element = book[index];
        //     console.log(index);
        //     console.log(element.patientIdNumber);
        //     tbodyPatientsList.innerHTML += `
        //                                 <tr>
        //                                     <td scope="col">${index + 1}</td>
        //                                     <td scope="col">${element.isbn}</td>
        //                                     <td scope="col">${element.title}</td>
        //                                     <td scope="col">${element.overdueFee}</td>
        //                                     <td scope="col">${element.publisher}</td>
        //                                     <td scope="col">${element.datePublished}</td>
        //                                 </tr>
        //                                 `;
        // };
    }
    displayStudent();
});
