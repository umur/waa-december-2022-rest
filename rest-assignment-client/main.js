const SERVER_ROOT = "http://localhost:8080";
window.onload = function () {
  fetchStudents();
  fetchCourses();
  document.getElementById("saveCourseBtn").onclick = saveCourse;
  document.getElementById("saveStudentBtn").onclick = saveStudent;
};

// display the students
function fetchStudents() {
  fetch(`${SERVER_ROOT}/students`)
    .then((response) => response.json())
    .then((students) => {
      loadStudents(students);
    })
    .catch((err) => {
      console.log(err);
    });
}

function loadStudents(students) {
  let html = `
    <tr>
    <th scope="col">#</th>
    <th scope="col">Firstname</th>
    <th scope="col">Lastname</th>
    <th scope="col">Email</th>
    <th scope="col">Major</th>
    <th scope="col">Action</th>
    </tr>
    `;
  if (students.length !== 0) {
    students.forEach((student) => {
      html += `
            <tr id="tr${student.id}">
            <th scope="row">${student.id}</th>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.major}</td>
            <td>
                <button class="btn btn-danger" onclick="deleteStudent(${student.id})">Delete</button>
                <button class="btn btn-success" onclick="getStudent(${student.id})">Update</button>
            </td>
        </tr>
            `;
    });
  } else {
    html += `<tr>
    <td colspan="6">No data to show</td>
  </tr>`;
  }
  document.getElementById("studentTable").innerHTML = html;
}

function deleteStudent(id) {
  fetch(`${SERVER_ROOT}/students/${id}`, {
    method: "DELETE",
  }).then((data) => {
    fetchStudents();
  });
}

function deleteCourse(id) {
  fetch(`${SERVER_ROOT}/courses/${id}`, {
    method: "DELETE",
  }).then((data) => {
    fetchCourses();
  });
}

// display the courses
function fetchCourses() {
  fetch(`${SERVER_ROOT}/courses`)
    .then((response) => response.json())
    .then((courses) => {
      loadCourses(courses);
    })
    .catch((err) => {
      console.log(err);
    });
}

function loadCourses(courses) {
  let html = `
        <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Code</th>
        <th scope="col">Action</th>
        </tr>
      `;
  if (courses.length !== 0) {
    courses.forEach((course) => {
      html += `
        <tr id="tr${course.id}">
            <th scope="row">${course.id}</th>
            <td>${course.name}</td>
            <td>${course.code}</td>
            <td>
                <button class="btn btn-danger" onclick="deleteCourse(${course.id})">Delete</button>
                <button class="btn btn-success" onclick="getCourse(${course.id})">Update</button>
            </td>
        </tr>
              `;
    });
  } else {
    html += `<tr>
      <td colspan="6">No data to show</td>
    </tr>`;
  }
  document.getElementById("courseTable").innerHTML = html;
}

function saveCourse(event) {
  event.preventDefault();
  const id = document.getElementById("id").value;
  const name = document.getElementById("name").value;
  const code = document.getElementById("code").value;

  fetch(`${SERVER_ROOT}/courses`, {
    method: "POST",
    body: JSON.stringify({
      id,
      name,
      code,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((prod) => {
      document.getElementById("courseSaveForm").reset();
      fetchCourses();
    })
    .catch((err) => console.log(err));
}

function getCourse(id) {
  fetch(`${SERVER_ROOT}/courses/${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      document.getElementById("formHeadCourse").innerText = "Update Course";
      document.getElementById("id").value = data.id;
      document.getElementById("name").value = data.name;
      document.getElementById("code").value = data.code;
      document.getElementById("saveCourseBtn").textContent = "Update";
      document.getElementById("saveCourseBtn").onclick = function (event) {
        updateCourse(event, data.id);
      };
    })
    .catch((err) => console.log(err));
}

function updateCourse(event, id) {
  event.preventDefault();
  const name = document.getElementById("name").value;
  const code = document.getElementById("code").value;

  fetch(`${SERVER_ROOT}/courses/${id}`, {
    method: "PUT",
    body: JSON.stringify({
      id,
      name,
      code,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((prod) => {
      document.getElementById("formHeadCourse").innerText = "Add a new Course";
      document.getElementById("courseSaveForm").reset();
      document.getElementById("saveCourseBtn").textContent = "Save";

      fetchCourses();
    })
    .catch((err) => console.log(err));
}

function saveStudent(event) {
  event.preventDefault();
  const id = document.getElementById("sid").value;
  const firstName = document.getElementById("firstname").value;
  const lastName = document.getElementById("lastname").value;
  const email = document.getElementById("email").value;
  const major = document.getElementById("major").value;

  fetch(`${SERVER_ROOT}/students`, {
    method: "POST",
    body: JSON.stringify({
      id,
      firstName,
      lastName,
      email,
      major,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((student) => {
      document.getElementById("studentSaveForm").reset();
      fetchStudents();
    })
    .catch((err) => console.log(err));
}

function getStudent(id) {
  fetch(`${SERVER_ROOT}/students/${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      document.getElementById("formHeadStudent").innerText = "Update Student";
      document.getElementById("sid").value = data.id;
      document.getElementById("firstname").value = data.firstName;
      document.getElementById("lastname").value = data.lastName;
      document.getElementById("email").value = data.email;
      document.getElementById("major").value = data.major;
      document.getElementById("saveStudentBtn").textContent = "Update";
      document.getElementById("saveStudentBtn").onclick = function (event) {
        updateStudent(event, data.id);
      };
    })
    .catch((err) => console.log(err));
}

function updateStudent(event, id) {
  event.preventDefault();
  const firstName = document.getElementById("firstname").value;
  const lastName = document.getElementById("lastname").value;
  const email = document.getElementById("email").value;
  const major = document.getElementById("major").value;

  fetch(`${SERVER_ROOT}/students/${id}`, {
    method: "PUT",
    body: JSON.stringify({
      id,
      firstName,
      lastName,
      email,
      major,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((prod) => {
      document.getElementById("formHeadStudent").innerText = "Add a Student";
      document.getElementById("studentSaveForm").reset();
      document.getElementById("saveStudentBtn").textContent = "Save";

      fetchStudents();
    })
    .catch((err) => console.log(err));
}
