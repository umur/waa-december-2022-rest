const apiUrl = "http://localhost:8080";

window.onload = function () {
  setupEventHandlers();
};

function setupEventHandlers() {
  document.getElementById("addCourse").onsubmit = addCourse;
}

function addCourse() {
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var body = JSON.stringify({
    id: document.getElementById("courseId").value,
    name: document.getElementById("courseName").value,
    code: document.getElementById("courseCode").value,
  });

  console.log(body);

  fetch(apiUrl + "/courses", {
    method: "POST",
    headers: myHeaders,
    body: body,
    redirect: "follow",
  })
    .then((response) => response.text())
    .then((response) => {
      location.href = "index.html";
    })
    .catch((error) => console.log("error", error));
}
