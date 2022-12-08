"use strict"
function fetchCourses() {
    fetch('http://localhost:8080/courses')
      .then(function(res) {
        return res.json();
      })
      .then(function(res) {
        if(res){
          res.forEach(function(course, index) {
            addItem(course.name, course.id, index);
          });
        }
        console.log(res);
      }).catch(function(err) {
        console.error("Error is: ", err);
      });
}

fetchCourses();

function addItem(name, id, index){
  var table = document.getElementById("courses-table-body");
  var row = document.createElement("tr");
  if(index % 2 == 0) {
    row.classList.add('table-primary');
  } else {
    row.classList.add('table-secondary');
  }
  var td1 = document.createElement("td");
  var td2 = document.createElement("td");
  var but = document.createElement("button");
  but.innerHTML = 'Delete';
  but.setAttribute('class', 'btn btn-danger');
  but.onclick = function() {deleteCourse(id)}
  row.setAttribute('id', 'course-' + id);
  td1.appendChild(document.createTextNode(name));
  td2.appendChild(but);
  row.appendChild(td1);
  row.appendChild(td2);
  table.appendChild(row);
}

function deleteCourse(id) {
  fetch('http://localhost:8080/courses/' + id, {method: 'DELETE'})
    .then(function(res) {    
      var row = document.getElementById('course-' + id);
      row.remove();
      console.log('delete this course', id);
      console.log(res);
    }).catch(function(err) {
      console.error("Error is: ", err);
    });
}
