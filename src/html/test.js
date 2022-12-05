window.onload=function(){
      function ajaxPost(url, data, callback) {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', url, true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
            xhr.setRequestHeader('Content-type', 'application/ecmascript');
            xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
            xhr.send(data);
            xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
              callback(xhr.responseText);
            }
           }
      }

    function createNewStudent(isEditCell,x,isCreate){

               let row = document.createElement("tr");
               let idTd = document.createElement("th");
               idTd.setAttribute("scope","row");

               const idTextDiv = document.createElement("div");
               idTextDiv.setAttribute("contenteditable",`${isEditCell}`);
               if(!isCreate){
                    const idText = document.createTextNode(x.id);
                    idTextDiv.appendChild(idText);
               }
               idTd.appendChild(idTextDiv);

               row.appendChild(idTd);

               let firstNameTd = document.createElement("td")
               const firstNameDiv = document.createElement("div");
               firstNameDiv.setAttribute("contenteditable",`${isEditCell}`);
                if(!isCreate){
                    const firstNameText = document.createTextNode(x.firstName);
                    firstNameDiv.appendChild(firstNameText);
                }
               firstNameTd.appendChild(firstNameDiv);
               row.appendChild(firstNameTd);


               let lastNameTd = document.createElement("td");
               const lastNameDiv = document.createElement("div");
               lastNameDiv.setAttribute("contenteditable",`${isEditCell}`);

                if(!isCreate){
                    const lastNameText = document.createTextNode(x.lastName);
                    lastNameDiv.appendChild(lastNameText);
                }
               lastNameTd.appendChild(lastNameDiv);
               row.appendChild(lastNameTd);

              let emailTd = document.createElement("td")
              const emailDiv = document.createElement("div");
               if(!isCreate){
                    const emailText = document.createTextNode(x.email);
                    emailDiv.appendChild(emailText);
              }
              emailDiv.setAttribute("contenteditable",`${isEditCell}`);
              emailTd.appendChild(emailDiv);

              row.appendChild(emailTd);


              let majorTd = document.createElement("td");
              const majorDiv = document.createElement("div");
              majorDiv.setAttribute("contenteditable",`${isEditCell}`);

                if(!isCreate){
                    const majorTdText = document.createTextNode(x.major);
                    majorDiv.appendChild(majorTdText);
                }

              majorTd.appendChild(majorDiv);
              row.appendChild(majorTd);

              let operationTd = document.createElement("td")
              let div = document.createElement("div")
              div.setAttribute("role","group");
              div.setAttribute("class","btn-group");
              div.setAttribute("aria-label","Basic mixed styles example");

              let deleteButton = document.createElement("button")
              deleteButton.setAttribute("type","button");
              deleteButton.setAttribute("class","btn btn-danger");
              const deleteButtonText = document.createTextNode("delete");
              deleteButton.appendChild(deleteButtonText);

              deleteButton.addEventListener('click', function(){
                      debugger;
                      let id = this.parentNode.parentNode.parentNode.firstChild.innerText;
                      ajaxDelete(`http://localhost:8080/student/${id}`,"",function(data){
                          window.location.reload();
                      })
              })

              div.appendChild(deleteButton);

              let updateButton = document.createElement("button")
              updateButton.setAttribute("type","button");
              updateButton.setAttribute("class","btn btn-warning");
              const updateButtonText = document.createTextNode("update");
              updateButton.appendChild(updateButtonText);
                updateButton.addEventListener('click', function(){
                    debugger;
                    let id = this.parentNode.parentNode.parentNode.firstChild.innerText;

                    ajaxDelete("");
                });
              div.appendChild(updateButton);
              operationTd.appendChild(div);

              let saveButton = document.createElement("button")
              saveButton.setAttribute("type","button");
              saveButton.setAttribute("class","btn btn-success");
              const saveButtonText = document.createTextNode("save");
              saveButton.appendChild(saveButtonText);
              saveButton.addEventListener('click', function(){
                      debugger;
                      let id = this.parentElement.parentElement.parentElement.childNodes.forEach(x=>console.log(x));

//                      ajaxDelete("");
              })
              operationTd.appendChild(saveButton);
              row.appendChild(operationTd);
              return row;

      }
    function ajaxDelete(url, data, callback) {
                var xhr = new XMLHttpRequest();
                  xhr.open('DELETE', url, true);
                   xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                    xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
                    xhr.setRequestHeader('Content-type', 'application/ecmascript');
                    xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
                  xhr.send(data);
                   xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                         callback(xhr.responseText);
                       }
                    }
            }

        function ajaxGet(url, callback) {
          var xhr = new XMLHttpRequest();

          xhr.open('GET', url, true);
            xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
            xhr.setRequestHeader('Access-Control-Allow-Origin', '*');

            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencode');
          xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
              callback(xhr.responseText);
            }
          }
          xhr.send();
        }

        function createNewCourse(isEditCell,x,isCreate){

             let row = document.createElement("tr");
             let idTd = document.createElement("th");
             idTd.setAttribute("scope","row");
             const idText = document.createTextNode(x.id);
             idTd.appendChild(idText);
             row.appendChild(idTd);

             let courseNameTd = document.createElement("td");
             let courseNameDiv =  document.createElement("div");
             courseNameDiv.setAttribute("contenteditable",`${isEditCell}`);
             const courseNameText = document.createTextNode(x.courseName);
             courseNameDiv.appendChild(courseNameText);
             courseNameTd.appendChild(courseNameDiv);
             row.appendChild(courseNameTd);


             let codeTd = document.createElement("td")
             const codeText = document.createTextNode(x.code);
              let codeDiv =  document.createElement("div");
              codeDiv.setAttribute("contenteditable",`${isEditCell}`);


             codeTd.appendChild(codeText);
             row.appendChild(codeTd);

            let operationTd = document.createElement("td")
            let div = document.createElement("div")
            div.setAttribute("role","group");
             div.setAttribute("class","btn-group");
            div.setAttribute("aria-label","Basic mixed styles example");

            let deleteButton = document.createElement("button")
            deleteButton.setAttribute("type","button");
            deleteButton.setAttribute("class","btn btn-danger");
            const deleteButtonText = document.createTextNode("delete");
            deleteButton.appendChild(deleteButtonText);
            deleteButton.addEventListener('click', function(){
                    debugger;
                    let id = this.parentNode.parentNode.parentNode.firstChild.innerText;
                    ajaxDelete(`http://localhost:8080/course/${id}`,"",function(data){
                      window.location.reload();
                    })
            })


            div.appendChild(deleteButton);
            let updateButton = document.createElement("button")
            updateButton.setAttribute("type","button");
            updateButton.setAttribute("class","btn btn-warning");
            const updateButtonText = document.createTextNode("update");
            updateButton.appendChild(updateButtonText);
            updateButton.addEventListener('click', function(){
                    debugger;
                    let id = this.parentNode.parentNode.parentNode.firstChild.innerText;
            })
            div.appendChild(updateButton);
            operationTd.appendChild(div);

            let saveButton = document.createElement("button")
            saveButton.setAttribute("type","button");
            saveButton.setAttribute("class","btn btn-success");
            const saveButtonText = document.createTextNode("save");
            saveButton.appendChild(saveButtonText);
            saveButton.addEventListener('click', function(){
                    debugger;
                    let id = this.parentNode.parentNode.parentNode.firstChild.innerText;

                    ajaxDelete("");
            })
            operationTd.appendChild(saveButton);
            row.appendChild(operationTd);

        }


        ajaxGet('http://localhost:8080/course', function (data) {
            var user = JSON.parse(data);
            console.log(user);

            user.forEach(x=>{

                document.getElementById("course_table_tbody").appendChild(row);

            });
        });

        document.getElementById("add_student").addEventListener('click', function(){
               let row = createNewStudent(true,null,true);
               document.getElementById("student_table_tbody").appendChild(row);
        })

        ajaxGet('http://localhost:8080/student', function (data) {
            var user = JSON.parse(data);
            console.log(user);
            user.forEach(x=>{
                let row = createNewStudent(false,x);
                document.getElementById("student_table_tbody").appendChild(row);
            });
        });
}