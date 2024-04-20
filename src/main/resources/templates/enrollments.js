document.addEventListener('DOMContentLoaded', function() {
    const userId = sessionStorage.getItem('userId');
    if (!userId) {
        alert('You must be logged in to view enrollments.');
        window.location.href = 'login.html';
        return;
    }

    fetch(`http://localhost:8080/api/courses/enrollments?userId=${userId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(enrollments => {
            const enrollmentsTableBody = document.querySelector('#enrollmentsTable tbody');
            enrollmentsTableBody.innerHTML = ''; // Clear previous content
            enrollments.forEach(enrollment => {
                let row = enrollmentsTableBody.insertRow();
                row.innerHTML = `
                    <td>${enrollment.course.title}</td>
                    <td>${enrollment.course.description}</td>
                    <td>£${enrollment.course.feesInPounds}</td>
                `;
            });
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to load enrollments: ' + error.message);
        });
});
