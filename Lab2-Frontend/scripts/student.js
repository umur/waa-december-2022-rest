"use strict"

let students = [];

const apiBaseUrl = "http://localhost:8081";

let selectedStudentId = null;

loadStudents();

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

function loadStudentDetails(studentId) {
    document.getElementById("submitButton").innerHTML = "Update";

    let url = apiBaseUrl + "/student/" + studentId;
    fetch(url)
        .then((res) => res.json())
        .then((data) => {
            document.getElementById('firstName').value = data.firstName;
            document.getElementById('lastName').value = data.lastName;
            document.getElementById('email').value = data.email;
        
            var majorOptions = document.getElementById('major');
        
            for (var i = 0; i < majorOptions.length; i++) {
                if (majorOptions[i].value == data.major) {
                    majorOptions[i].selected = true;
                    break;
                }
            }

            selectedStudentId = data.id;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Courses");
        });
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
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal" 
                        data-bs-target="#studentDetailsModal"
                        onclick="loadStudentDetails('${stu.id}')">
                        <i class="fa fa-edit"> Edit</i>
                </button>
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal"
                        data-bs-target="#confirmDeleteModal"
                        onclick="confirmDeleteStudent('${stu.id}')">
                        <i class="fa fa-trash"> Delete</i>
                </button>
            </td>
        </tr>
    `;
}

function submitForm() {
    if (!selectedStudentId) addStudent();
    else updateStudent();
}

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

function confirmDeleteStudent(studentId) {
    selectedStudentId = studentId;
}

function closeConfirmDeleteModal() {
    const deleteConfirmModal = document.getElementById("confirmDeleteModal");
    const modal = bootstrap.Modal.getInstance(deleteConfirmModal);
    modal.hide();

    selectedStudentId = null;
}

function addStudent() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    const major = document.getElementById('major').value;

    const student = { id: 0, firstName, lastName, email, major };
    const data = JSON.stringify(student);

    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let url = apiBaseUrl + "/student";
    fetch(url, {
        method: "POST",
        headers: myHeaders,
        body: data,
        redirect: "follow",
    })
        .then((res) => {
            console.log(res.text());
        })
        .then((res) => {
            closeStudentDetailsModal();
            loadStudents();
        })
        .catch((error) => console.log("error", error));
}

function updateStudent() {
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const major = document.getElementById('major').value;

    const data = JSON.stringify({ id: selectedStudentId, firstName, lastName, email, major })
    
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let url = apiBaseUrl + "/student/" + selectedStudentId;
    fetch(url, {
        method: "PUT",
        headers: myHeaders,
        body: data,
        redirect: "follow",
    })
        .then((res) => {
            console.log(res.text());
        })
        .then((res) => {
            closeStudentDetailsModal();
            loadStudents();
        })
        .catch((error) => console.log("error", error));
}

function deleteStudent() {
    let url = apiBaseUrl + "/student/" + selectedStudentId;
    fetch(url, {
        method: "DELETE",
    })
        .then((res) => {
            closeConfirmDeleteModal();
            loadStudents();
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error deleting Student " + id);
        });
}