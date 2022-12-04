const apiUrl = "http://localhost:8080";

window.onload = function () {
  setupEventHandlers();
};

function setupEventHandlers() {
  document.getElementById("addStudent").onsubmit = addStudent;
}

function addStudent() {
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var body = JSON.stringify({
    id: document.getElementById("stuId").value,
    firstName: document.getElementById("stuFName").value,
    lastName: document.getElementById("stuLName").value,
    email: document.getElementById("stuEmail").value,
    major: document.getElementById("stuMajor").value,
  });

  console.log(body);

  fetch(apiUrl + "/students", {
    method: "POST",
    headers: myHeaders,
    body: body,
    redirect: "follow",
  })
    .then((response) => {
      response.text();
    })
    .then((response) => {
      location.href = "index.html";
    })
    .catch((error) => console.log("error", error));
}
