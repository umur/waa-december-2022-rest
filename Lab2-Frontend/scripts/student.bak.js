"use strict"

let students = [];

const apiBaseUrl = "http://localhost:8081";

let selectedStudentId = null;

function closeStudentDetailsModal() {
    const studentModalElement = document.getElementById("studentDetailsModal");
    const modal = bootstrap.Modal.getInstance(studentModalElement);
    modal.hide();

    document.getElementById('firstName').value = "";
    document.getElementById('lastName').value = "";
    document.getElementById('email').value = "";
    document.getElementById('major').value = "";

    document.getElementById("submitButton").innerHTML = "Save";
    selectedStudentId = null;
}

function submitForm() {
    if (!selectedStudentId) addStudent();
    else updateStudent();
}

function writeStudentRow(stu) {
    const student = encodeURIComponent(JSON.stringify(stu));
    return `
        <tr id="row-stu-${stu.id}">
            <td>${stu.id}</td>
            <td>${stu.firstName}</td>
            <td>${stu.lastName}</td>
            <td>${stu.email}</td>
            <td>${stu.major}</td>
            <td class="w-20">
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.8em;" 
                        data-bs-toggle="modal" 
                        data-bs-target="#studentDetailsModal"
                        onclick="fillStudentDetailsInModal('${student}')">
                    <span class="glyphicon glyphicon-edit"> Edit</span>
                </button>
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.8em;"
                        onclick="deleteStudent('${stu.id}')">
                <span class="glyphicon glyphicon-trash"> Delete</span>
                </button>
            </td>
        </tr>
    `;
}

function fillStudentDetailsInModal(stu) {
    document.getElementById("submitButton").innerHTML = "Update";
    const student = JSON.parse(decodeURIComponent(stu));

    document.getElementById('firstName').value = student.firstName;
    document.getElementById('lastName').value = student.lastName;
    document.getElementById('email').value = student.email;

    var majorOptions = document.getElementById('major');

    for (var i = 0; i < majorOptions.length; i++) {
        if (majorOptions[i].value == student.major) {
            majorOptions[i].selected = true;
            break;
        }
    }

    selectedStudentId = student.id;
}

function addStudent() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    const major = document.getElementById('#major').value;

    const student = { id: students.length + 1, firstName, lastName, email, major };

    const studentListContent = writeStudentRow(student);
    const tableBody = document.getElementById("student-table-body");
    tableBody.innerHTML += studentListContent;

    closeStudentDetailsModal();
}

function updateStudent() {
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const major = document.getElementById('major').value;

    const stuJson = JSON.stringify({ id: selectedStudentId, firstName, lastName, email, major })
    const student = encodeURIComponent(stuJson);

    const firstNameField = document.querySelector("#row-stu-" + selectedStudentId + " td:nth-child(2)");
    const lastNameField = document.querySelector("#row-stu-" + selectedStudentId + " td:nth-child(3)");
    const emailField = document.querySelector("#row-stu-" + selectedStudentId + " td:nth-child(4)");
    const majorField = document.querySelector("#row-stu-" + selectedStudentId + " td:nth-child(5)");
    const updateButtonfield = document.querySelector("#row-stu-" + selectedStudentId + " td:nth-child(6) button:nth-child(1)");

    updateButtonfield.setAttribute('onclick', 'fillStudentDetailsInModal("' + student + '")');

    firstNameField.innerHTML = firstName;
    lastNameField.innerHTML = lastName;
    emailField.innerHTML = email;
    majorField.innerHTML = major;

    closeStudentDetailsModal();
}

function deleteStudent(stuId) {
    const studentRow = document.getElementById("row-stu-" + stuId);
    studentRow.remove();
}

function loadStudents() {
    let url = apiBaseUrl + "/student";
    fetch(url)
        .then((res) => res.json())
        .then((data) => {
            students = data;
            let studentListContent = "";

            students.forEach(student => (studentListContent += writeStudentRow(student)));

            const studentTableBody = document.getElementById("student-table-body");
            studentTableBody.innerHTML = studentListContent;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Students");
        });
}

loadStudents();