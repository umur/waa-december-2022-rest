var server = "localhost"
var port = "8080"

window.onload = function () {
  handleOnLoad();
};

function handleOnLoad() {
  // document.getElementById("getAllCoursesBtn").onclick = getAllCourses
}

function clearTable(table) {
  let tableHeaderRowCount = 1;
  let rowCount = table.rows.length;
  for (let i = tableHeaderRowCount; i < rowCount; i++) {
    table.deleteRow(tableHeaderRowCount);
  }
}

async function getAllCourses() {

  let courses = await fetch(`http://${server}:${port}/courses`)
    .then((response) => response.json())

  let table = document.getElementById("course_table");

  clearTable(table)

  let i = 0;
  courses.forEach(course => {
    let row = table.insertRow();

    let cellNo = row.insertCell(0);
    cellNo.innerHTML = i;
    i++;

    let cellId = row.insertCell(1);
    cellId.innerHTML = course.id;

    let cellName = row.insertCell(2);
    cellName.innerHTML = course.name;

    let cellCode = row.insertCell(3);
    cellCode.innerHTML = course.code;
  });
}

async function getCourseById(id) {

  let course = await fetch(`http://${server}:${port}/courses/${id}`)
    .then((response) => response.json())

  let table = document.getElementById("course_table");

  clearTable(table)

  let row = table.insertRow(1);

  let cellNo = row.insertCell(0);
  cellNo.innerHTML = 1;

  let cellId = row.insertCell(1);
  cellId.innerHTML = course.id;

  let cellName = row.insertCell(2);
  cellName.innerHTML = course.name;

  let cellCode = row.insertCell(3);
  cellCode.innerHTML = course.code;
}

async function addCourse() {
  const settings = {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    },
    body: {
      "name": "DBMS",
      "code": "CS425"
    }
  };
  try {
    const fetchResponse = await fetch(`http://${server}:${port}/courses/`, settings);
    const data = await fetchResponse.json();
    return data;
  } catch (e) {
    return e;
  }

}