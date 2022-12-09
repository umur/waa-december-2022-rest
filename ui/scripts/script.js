window.onload = function(){

    const getStudentsUrl = 'http://localhost:8080/students';
    const getCoursesUrl = 'http://localhost:8080/courses';

    let addMode = false;

    function handleDeleteSuccess(){
        if(getActiveMenu() === 'course'){
            displayMsgBox("Course deleted successfully!");
            fetchApi(getCoursesUrl, 'GET', handleFetchCourse)
        } else {
            displayMsgBox("Student deleted successfully!");
            fetchApi(getStudentsUrl, 'GET', handleFetchStudent)
        }
    }

    function handleDelete(id){
        let url = (getActiveMenu() === 'course') ? getCoursesUrl : getStudentsUrl;
        url += '/' + id;
        fetchApi(url, 'DELETE', handleDeleteSuccess);
    }

    //create img tag
    function createImg(){
        let elem = document.createElement('img');
        elem.setAttribute('src',"images/delete-24.png");
        elem.setAttribute('alt', "delete");
        elem.setAttribute('height', "16px");
        return elem;
    }

    //create anchor element
    function createAnchor(id){
        let anchor = document.createElement("a");
        anchor.addEventListener("click", () => handleDelete(id));
        anchor.href = "#";
        anchor.appendChild(createImg());
        anchor.className = "padded";

        return anchor;
    }

    //create li element
    function createRow(id, text){
        let elem = document.createElement("li");
        elem.id = id;
        elem.innerHTML = text;
        elem.appendChild(createAnchor(id));

        return elem;
    }

    function handleFetchStudent(data){
        let list = document.getElementById("list");
        list.innerHTML = '';
        for(obj of data){
            let elem = createRow(obj.id, obj.id + " - " + obj.firstName + " " + obj.lastName + " - " + obj.email + " - " + obj.major);
            list.appendChild(elem);
        }
    }

    function handleFetchCourse(data){
        let list = document.getElementById("list");
        list.innerHTML = '';
        for(obj of data){
            let elem = createRow(obj.id, obj.id + " - " + obj.name + " " + " - " + obj.code);
            list.appendChild(elem);
        }
    }

    async function fetchApi(url, method, callback, data){
        if(method == "DELETE"){
            await fetch(url, { credentials: 'omit', method: method})
                    .then(() => callback())
        } else if(method == "POST"){
            await fetch(url, { 
                credentials: 'omit', 
                method: method, 
                headers: {
                'Content-Type': 'application/json'
                }, 
                body: JSON.stringify(data) 
            })
            .then(() => callback())
        } else {
            await fetch(url, { credentials: 'omit', method: method })
                    .then((response) => response.json())
                    .then(data => callback(data))
        }
    }

    function toggleMenu(){
        document.getElementById("course-menu").classList.toggle("nav-active");
        document.getElementById("student-menu").classList.toggle("nav-active");
    }

    function setTitle(title){
        document.getElementById("title").innerText = title;
    }

    function getActiveMenu(){
        if(document.getElementById('course-menu').classList.contains('nav-active'))
            return 'course';
        else 
            return 'student';
    }

    function getStudents(){
        fetchApi(getStudentsUrl, 'GET', handleFetchStudent);
    }

    function getCourses(){
        fetchApi(getCoursesUrl, 'GET', handleFetchCourse);
    }

    function handleStudentClick(){
        if(getActiveMenu() === 'student')
            return;

        toggleMenu();
        setTitle('Students');
        if(addMode)
            handleAdd();
        else
            getStudents();
    }

    function handleCourseClick(){
        if(getActiveMenu() === 'course')
            return;

        toggleMenu();
        setTitle('Courses');

        if(addMode)
            handleAdd();
        else
            getCourses();
    }

    function handleAdd(){

        //enable form and hide list
        addMode = true;
        document.getElementById("list").classList.add("hidden");
        if(getActiveMenu() === 'course'){
            document.getElementById("course-form").classList.remove("hidden");
            document.getElementById("student-form").classList.add("hidden");
        } else {
            document.getElementById("student-form").classList.remove("hidden");
            document.getElementById("course-form").classList.add("hidden");
        }
    }

    function displayMsgBox(message){
        const elem = document.getElementById("msg-box");
        elem.innerText = message;
        elem.classList.remove("hidden");
    }

    function handleSaveCallback(){
        if(getActiveMenu() === 'course'){
            getCourses();
            displayMsgBox("Course saved successfully!");
            document.getElementById("course-form").classList.add("hidden");
        } else {
            getStudents();
            displayMsgBox("Student saved successfully!");
            document.getElementById("student-form").classList.add("hidden");
        }
    }

    function handleSave(e){
        e.preventDefault();
        addMode = false;
        document.getElementById("list").classList.remove("hidden");
        if(getActiveMenu() === 'course'){
            const course = {
                id: document.getElementById("course-id").value,
                name: document.getElementById("course-name").value,
                code: document.getElementById("course-code").value,
            };
            fetchApi(getCoursesUrl, 'POST', handleSaveCallback, course);
        } else {
            const student = {
                id: document.getElementById("student-id").value,
                firstName: document.getElementById("student-fname").value,
                lastName: document.getElementById("student-lname").value,
                email: document.getElementById("student-email").value,
                major: document.getElementById("student-major").value,
            };

            fetchApi(getStudentsUrl, 'POST', handleSaveCallback, student);
        }
    }

    //course
    document.getElementById("course-menu").addEventListener("click", handleCourseClick);
    //student
    document.getElementById("student-menu").addEventListener("click", handleStudentClick);

    document.getElementById("add-btn").addEventListener("click", handleAdd);

    document.getElementById("save-student").addEventListener("click", handleSave);
    document.getElementById("save-course").addEventListener("click", handleSave);

    //by default open students
    handleStudentClick();
};