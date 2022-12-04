/**
 * home.js
 */
'use strict';
document.addEventListener('DOMContentLoaded', function (event) {
  let url = 'http://localhost:8080/students';

  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (json) {
      let students = json;
      populateTable(students);
    })
    .catch(function (error) {
      console.log(error);
    });
  let majorButton = document.getElementById('majorSearch');
  let idButton = document.getElementById('idSearch');

  majorButton.addEventListener('click', function (event) {
    event.preventDefault();
    let search = document.getElementById('search').value;
    fetch(url + '/major/' + search)
      .then(function (response) {
        return response.json();
      })
      .then(function (json) {
        populateTable(json);
      });
  });

  function populateTable(data) {
    let table = document.getElementById('tableBody');
    table.innerHTML = '';
    for (let i = 0; i < data.length; i++) {
      let row = table.insertRow(i);
      let id = row.insertCell(0);
      let firstName = row.insertCell(1);
      let lastName = row.insertCell(2);
      let email = row.insertCell(3);
      let major = row.insertCell(4);
      id.innerHTML = data[i].id;
      firstName.innerHTML = data[i].firstName;
      lastName.innerHTML = data[i].lastName;
      email.innerHTML = data[i].email;
      major.innerHTML = data[i].major;
    }
  }
});
