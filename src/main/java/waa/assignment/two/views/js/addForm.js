/**
 * addForm.js
 */
'use strict';

document.addEventListener('DOMContentLoaded', function (event) {
  let form = document.getElementById('studentForm');
  form.addEventListener('submit', function (event) {
    event.preventDefault();
    let student = {
      id: document.getElementById('id').value,
      firstName: document.getElementById('firstName').value,
      lastName: document.getElementById('lastName').value,
      email: document.getElementById('email').value,
      major: document.getElementById('major').value,
      coursesTaken: [
        {
          id: document.getElementById('courseId').value,
          name: document.getElementById('courseName').value,
          code: document.getElementById('courseCode').value,
        },
      ],
    };
    fetch('http://localhost:8080/students', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(student),
    })
      .then(function (json) {
        console.log(json);
      })
      .catch(function (error) {
        console.log(error);
      });
  });
});
