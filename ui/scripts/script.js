window.onload = function(){

    const getStudentsUrl = 'http://localhost:8080/students';
    const getCoursesUrl = 'http://localhost:8080/courses';

    function handleDeleteSuccess(){
        if(getActiveMenu() === 'course'){
            fetchApi(getCoursesUrl, 'GET', handleFetchCourse)
        } else {
            fetchApi(getStudentsUrl, 'GET', handleFetchStudent)
        }
    }

    function handleDelete(id){
        let url = (getActiveMenu() === 'course') ? getCoursesUrl : getStudentsUrl;
        url += '/' + id;
        fetchApi(url, 'DELETE', handleDeleteSuccess);
    }

    //create anchor element
    function createAnchor(id){
        let anchor = document.createElement("a");
        anchor.addEventListener("click", () => handleDelete(id));
        anchor.href = "#";
        anchor.innerText = "delete";
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

    async function fetchApi(url, method, callback){
        if(method == "DELETE"){
            await fetch(url, { credentials: 'omit', method: method })
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

    function handleStudentClick(){
        toggleMenu();
        setTitle('Students');
        fetchApi(getStudentsUrl, 'GET', handleFetchStudent);
    }

    function handleCourseClick(){
        toggleMenu();
        setTitle('Courses');
        fetchApi(getCoursesUrl, 'GET', handleFetchCourse);
    }

    //course
    document.getElementById("course-menu").addEventListener("click", handleCourseClick);
    //student
    document.getElementById("student-menu").addEventListener("click", handleStudentClick);

    //by default open students
    handleStudentClick();
};