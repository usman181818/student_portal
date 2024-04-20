document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/api/courses')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(courses => {
            const coursesTableBody = document.querySelector('#coursesTable tbody');
            coursesTableBody.innerHTML = ''; // Clear previous content
            courses.forEach(course => {
                let row = coursesTableBody.insertRow();
                row.innerHTML = `
                    <td>${course.title}</td>
                    <td>${course.description}</td>
                    <td>£${course.feesInPounds}</td>
                    <td><button class="actionButton" onclick="enrollCourse(${course.id})">Enroll</button></td>
                `;
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

function enrollCourse(courseId) {
    const userId = sessionStorage.getItem('userId');
    if (!userId) {
        alert('You must be logged in to enroll in a course.');
        return;
    }

    fetch(`http://localhost:8080/api/courses/enroll?userId=${userId}&courseId=${courseId}`, {
        method: 'POST', // Assuming the server expects a POST request to enroll
        headers: {
            'Content-Type': 'application/json'
            // Include additional headers like authorization tokens if required
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            return response.text().then(text => { throw new Error(text) });
        }
    })
    .then(data => {
        alert(`Successfully enrolled in the course: ${data.course.title}`);
    })
    .catch(error => {
        console.error('Error:', error);
        alert(error.message); // The message returned from the backend in case of an error
    });
}


document.getElementById('signOut').addEventListener('click', function() {
    sessionStorage.clear();
    window.location.href = 'login.html';
});
