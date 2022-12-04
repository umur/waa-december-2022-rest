function btnDeleteStudentEventHandler(id) {
    console.log(id);
    let url = apiUrl + "/students/" + id;
    fetch(url, {
      method: "DELETE",
    })
      .then((res) => getStudents())
      .catch(function (err) {
        console.log(err);
        console.log("Error deleting Student " + id);
      });
  }
  
  function getStudents() {
    let url = apiUrl + "/students";
    fetch(url)
      .then((res) => res.json())
      .then((data) => {
        students = data;
        showStudents();
      })
      .catch(function (err) {
        console.log(err);
        console.log("Error fetching Students");
      });
  }
  
  function showStudents() {
    let studentTblHtml = `<table class="table"> <thead> <th>ID</th> <th>FirstName</th> <th>LastName</th> <th>Email</th> <th>Major</th> <th>Action</th> </thead> <tbody>`;
    students.forEach((stu) => {
      let entry = `<tr> 
              <td>${stu.id}</td> <td>${stu.firstName}</td> <td>${stu.lastName}</td> <td>${stu.email}</td> <td>${stu.major}</td> 
              <td><button class="btnDeleteStudent btn btn-danger" onclick="btnDeleteStudentEventHandler(${stu.id})">Delete</button></td>
          </tr>`;
      studentTblHtml += entry;
    });
    studentTblHtml += "</tbody></table>";
    document.getElementById("studentList").innerHTML = studentTblHtml;
  }
  
  
