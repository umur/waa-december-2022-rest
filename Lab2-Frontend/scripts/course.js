"use strict"

let courses = [];

const apiBaseUrl = "http://localhost:8081";

let selectedCourseId = null;

loadCourses();

function loadCourses() {
    let url = apiBaseUrl + "/course";
    fetch(url)
        .then((res) => res.json())
        .then((data) => {
            courses = data;
            let courseListContent = "";

            courses.forEach(course => (courseListContent += writeCourseRow(course)));

            const courseTableBody = document.getElementById("course-table-body");
            courseTableBody.innerHTML = courseListContent;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Courses");
        });
}

function loadCourseDetails(courseId) {
    document.getElementById("submitButton").innerHTML = "Update";

    let url = apiBaseUrl + "/course/" + courseId;
    fetch(url)
        .then((res) => res.json())
        .then((data) => {
            document.getElementById('name').value = data.name;
            document.getElementById('code').value = data.code;

            selectedCourseId = data.id;
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error fetching Courses");
        });
}

function writeCourseRow(crs) {
    const course = encodeURIComponent(JSON.stringify(crs));
    return `
        <tr id="row-crs-${crs.id}">
            <td>${crs.id}</td>
            <td>${crs.name}</td>
            <td>${crs.code}</td>
            <td class="w-20">
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal" 
                        data-bs-target="#courseDetailsModal"
                        onclick="loadCourseDetails('${crs.id}')">
                        <i class="fa fa-edit"> Edit</i>
                </button>
                <button class="btn btn-sm btn-outline-primary py-0" 
                        style="font-size: 0.95em;" 
                        data-bs-toggle="modal"
                        data-bs-target="#confirmDeleteModal"
                        onclick="confirmDeleteCourse('${crs.id}')">
                        <i class="fa fa-trash"> Delete</i>
                </button>
            </td>
        </tr>
    `;
}

function submitForm() {
    if (!selectedCourseId) addCourse();
    else updateCourse();
}

function closeCourseDetailsModal() {
    const courseModalElement = document.getElementById("courseDetailsModal");
    const modal = bootstrap.Modal.getInstance(courseModalElement);
    modal.hide();

    document.getElementById('name').value = "";
    document.getElementById('code').value = "";

    document.getElementById("submitButton").innerHTML = "Save";
    selectedCourseId = null;
}

function confirmDeleteCourse(courseId) {
    selectedCourseId = courseId;
}

function closeConfirmDeleteModal() {
    const deleteConfirmModal = document.getElementById("confirmDeleteModal");
    const modal = bootstrap.Modal.getInstance(deleteConfirmModal);
    modal.hide();

    selectedCourseId = null;
}

function addCourse() {
    var name = document.getElementById('name').value;
    var code = document.getElementById('code').value;

    const course = { id: 0, name, code };
    const data = JSON.stringify(course);

    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let url = apiBaseUrl + "/course";
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
            closeCourseDetailsModal();
            loadCourses();
        })
        .catch((error) => console.log("error", error));
}

function updateCourse() {
    const name = document.getElementById('name').value;
    const code = document.getElementById('code').value;

    const data = JSON.stringify({ id: selectedCourseId, name, code })

    // Save data on the server side
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let url = apiBaseUrl + "/course/" + selectedCourseId;
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
            closeCourseDetailsModal();
            loadCourses();
        })
        .catch((error) => console.log("error", error));
}

function deleteCourse() {
    let url = apiBaseUrl + "/course/" + selectedCourseId;
    fetch(url, {
        method: "DELETE",
    })
        .then((res) => {
            closeConfirmDeleteModal();
            loadCourses();
        })
        .catch(function (err) {
            console.log(err);
            console.log("Error deleting Course " + id);
        });
}