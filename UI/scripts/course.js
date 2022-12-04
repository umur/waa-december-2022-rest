function btnDeleteCourseEventHandler(id) {
  console.log(id);
  let url = apiUrl + "/courses/" + id;
  fetch(url, {
    method: "DELETE",
  })
    .then((res) => getCourses())
    .catch(function (err) {
      console.log(err);
      console.log("Error deleting Course " + id);
    });
}

function getCourses() {
  let url = apiUrl + "/courses";
  fetch(url)
    .then((res) => res.json())
    .then((data) => {
      courses = data;
      showCourses();
    })
    .catch(function (err) {
      console.log(err);
      console.log("Error fetching Courses");
    });
}

function showCourses() {
  let courseTblHtml = `<table class="table"> <thead> <th>ID</th> <th>Name</th> <th>Code</th> <th>Action</th> </thead> <tbody>`;
  courses.forEach((course) => {
    let entry = `<tr> 
              <td>${course.id}</td> <td>${course.name}</td> <td>${course.code}</td> 
              <td><button class="btnDeleteCourse btn btn-danger" onclick="btnDeleteCourseEventHandler(${course.id})">Delete</button></td>
          </tr>`;
    courseTblHtml += entry;
  });
  courseTblHtml += "</tbody></table>";
  document.getElementById("courseList").innerHTML = courseTblHtml;
}

