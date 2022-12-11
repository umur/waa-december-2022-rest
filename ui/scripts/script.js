window.onload = function(){

    const getStudentsUrl = 'http://localhost:8080/students';
    const getCoursesUrl = 'http://localhost:8080/courses';
    let token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJuZ3UzZFRUYXdyV3ZkQzRSWDJTOFpMVzNQOGltMVBGdVZyaEUzN2dkWXc0In0.eyJleHAiOjE2NzA3NzgwMjksImlhdCI6MTY3MDc3MDgyOSwiYXV0aF90aW1lIjoxNjcwNzcwODE2LCJqdGkiOiJjYmMxYWEwNi00M2ZjLTQ5MWUtYTIxOS0wYzRhNWFhZGJkMDEiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwOTAvcmVhbG1zL2RldmVsb3BtZW50IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjkyN2MwNmQ5LWQzZTAtNGE5OS1iMjVmLWFlMjNjMGUzNmQ3MCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFwcC0wMDAxIiwic2Vzc2lvbl9zdGF0ZSI6ImQ5ODM3N2ZhLWY3YWYtNDRjZC04NTlmLTkyMmVlY2Q4MGFmMyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJkZWZhdWx0LXJvbGVzLWRldmVsb3BtZW50IiwidW1hX2F1dGhvcml6YXRpb24iLCJ1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiZDk4Mzc3ZmEtZjdhZi00NGNkLTg1OWYtOTIyZWVjZDgwYWYzIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiQmlub2QgR3VydW5nIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiYmlub2QzMTgiLCJnaXZlbl9uYW1lIjoiQmlub2QiLCJmYW1pbHlfbmFtZSI6Ikd1cnVuZyIsImVtYWlsIjoiYmlub2QzMThAZ21haWwuY29tIn0.MIE5pqjsVwdjFeoABUHHZMh5r7P5SWSZlJX_dabjMoH-S6P6jL-s_GijPNZBrKTaPifxLsr4LQT4iCwUFYZh8Cg_SJatD1wGJgoCU6Aw3mriK1tNIrRkFTQj63_29tPsO9D-rm3P-dnVkI_lItnk_udObyi28LwwMBAo6cssBk707lPlVlRye-tokLYFXO9tvKKXL4GAHlQIVxH2wmWzFMr7Vp0ID7lPXRmr2RLFhxg7tj3V-5TwGfSeHmFhxmk8UacXuT0Cz8eNmfxgaJ2J-Jp4TVTqDY2JzMBE9GBJsBq0aleSRRWv-tlY4-VepP-BlPdXTEgUF8pZwF8j6E-jAw";//"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJuZ3UzZFRUYXdyV3ZkQzRSWDJTOFpMVzNQOGltMVBGdVZyaEUzN2dkWXc0In0.eyJleHAiOjE2NzA3Nzc0OTcsImlhdCI6MTY3MDc3MDI5NywiYXV0aF90aW1lIjoxNjcwNzY5MjMwLCJqdGkiOiI4ZDJlNjg2MC01NzIzLTQ1YzItOWM2MC0yZGZmMWRiOWNkN2QiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwOTAvcmVhbG1zL2RldmVsb3BtZW50IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijg0NWFiNTBjLTNiMzAtNGZkMy1hZjY5LWVkYzhlYmE5NGJhYSIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFwcC0wMDAxIiwic2Vzc2lvbl9zdGF0ZSI6Ijg2YzY2MmQxLWI0OWEtNDVmYy05MGQxLTU5OWMyMjA2ZDAxNSIsImFjciI6IjAiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsImRlZmF1bHQtcm9sZXMtZGV2ZWxvcG1lbnQiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6Ijg2YzY2MmQxLWI0OWEtNDVmYy05MGQxLTU5OWMyMjA2ZDAxNSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJpbm9kIEd1cnVuZyIsInByZWZlcnJlZF91c2VybmFtZSI6ImJpbm9kZ3VydW5nIiwiZ2l2ZW5fbmFtZSI6IkJpbm9kIiwiZmFtaWx5X25hbWUiOiJHdXJ1bmciLCJlbWFpbCI6ImJpbm9kLmd1cnVuZ0BtaXUuZWR1In0.lJ71YmoCt1JvwJRWLeEsTHM1BxniLRAemvHGeWseik7Br5L-76U-ppHRjlPMYDGrJkOSHjbpt0B7HImurJd-40YdFAk1wCqODtto3WuKlGeypEn0ZaEYofWfD0QW29UR3-6keuFHs5HX9sSysiYrxrkND-slm8hcD27t1lW94xol3IaeNpy-e9xBBN5CTSutA_sSvpobKSYMaZvde7GdBQZxYr-LagzHI1pR5hknUis9QW4NVwy2UT9CpaM6n_TcCpY9lriS7JUQ6mBi_RYG0VzlfDxod3eBj7SvSPMS6YGjMTkPT3K00sAUJZSQSM_UdEzac--D97-NZxYc7nJ_jQ";

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
            await fetch(url, {
                    //credentials: 'omit',
                    method: method,
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                })
                .then((result) => {
                    if(result.status < 300)
                        callback();
                    else
                        displayErrorBox("Error deleting!");
                })
                .catch((error) => {
                    console.log("ERRROORRRROR",error);
                })
        } else if(method == "POST"){
            await fetch(url, { 
                //credentials: 'omit',
                method: method, 
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                }, 
                body: JSON.stringify(data) 
            })
            .then((result) => {
                if(result.status < 300)
                    callback();
                else
                    displayErrorBox("Error creating!");
            })
        } else {
            await fetch(url, {
                //credentials: 'omit',
                method: method,
                headers: {
                    'Authorization': `Bearer ${token}`
                    }
                }
            )
            .then((response) => response.json())
                .then((result) => {
                    if(result.status === 401 || result.status === 403)
                        displayErrorBox("Unauthorized");
                    else
                        return result;
                })
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

        hideMessage();
        hideError();
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

        hideMessage();
        hideError();
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
        hideError();
        const elem = document.getElementById("msg-box");
        elem.innerText = message;
        elem.classList.remove("hidden");
    }

    function displayErrorBox(message){
        hideMessage();
        const elem = document.getElementById("error-box");
        elem.innerText = message;
        elem.classList.remove("hidden");
    }

    function hideMessage(){
        document.getElementById("msg-box").classList.add("hidden");
    }

    function hideError(){
        document.getElementById("error-box").classList.add("hidden");
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