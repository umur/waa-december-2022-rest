function fetchCourses() {
    console.log("fetching courses");
    
    let url = 'http://localhost:8080/courses';
    let cols = ["id", "name", "code"];

    fetchData(url, cols);
}

function fetchStudents() {
    console.log("fetching students");
    
    let url = 'http://localhost:8080/students';
    let cols = ["id", "firstName", "lastName", "email", "major"];

    fetchData(url, cols);
}

function fetchData(url, cols) {
    fetch(url)
    .then(res => res.json())
    .then(datas => buildTable(datas, cols))
    .catch(err => { throw err });
}

function buildTable(datas, cols) {
    let table = document.getElementsByTagName("table")[0];
    let thead = document.createElement("thead");
    let tbody = document.createElement("tbody");
    let tr = document.createElement("tr");
    table.innerHTML = "";

    cols.forEach(col => {
        let th = document.createElement("th");
        th.textContent = col;
        tr.appendChild(th);
    });

    datas.forEach(data => {
        let tr = document.createElement("tr");
        cols.forEach(col => {
            let td = document.createElement("td");
            console.log(data[col], data, col);
            td.textContent = data[col];
            tr.appendChild(td);
        })
        tbody.appendChild(tr);
    });

    thead.appendChild(tr);
    table.appendChild(thead);
    table.appendChild(tbody);
}