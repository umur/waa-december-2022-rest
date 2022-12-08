"use strict"
function fetchStudents() {
    fetch('http://localhost:8080/students')
      .then(function(res) {
        return res.json();
      })
      .then(function(res) {
        if(res){
          res.forEach(function(student, index) {
            addItem(student.firstName + ' ' + student.lastName, student.id, index);
          });
        }
        console.log(res);
      }).catch(function(err) {
        console.error("Error is: ", err);
      });
}

fetchStudents();

function addItem(name, id, index){
  var table = document.getElementById("students-table-body");
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
  but.onclick = function() {deleteStudent(id)}
  row.setAttribute('id', 'student-' + id);
  td1.appendChild(document.createTextNode(name));
  td2.appendChild(but);
  row.appendChild(td1);
  row.appendChild(td2);
  table.appendChild(row);
}

function deleteStudent(id) {
  fetch('http://localhost:8080/students/' + id, {method: 'DELETE'})
    .then(function(res) {    
      var row = document.getElementById('student-' + id);
      row.remove();
      console.log('delete this student', id);
      console.log(res);
    }).catch(function(err) {
      console.error("Error is: ", err);
    });
}
