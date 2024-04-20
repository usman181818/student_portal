document.addEventListener('DOMContentLoaded', function() {
    const userId = sessionStorage.getItem('userId');
    if (!userId) {
        alert('You must be logged in to view your profile.');
        window.location.href = 'login.html';
        return;
    }

    // Get student profile data
    fetch(`http://localhost:8080/api/students/${userId}`)
        .then(response => response.json())
        .then(student => {
            document.getElementById('firstName').value = student.firstName || '';
            document.getElementById('lastName').value = student.lastName || '';
        })
        .catch(error => {
            console.error('Error fetching student data:', error);
            alert('Error fetching profile data.');
        });

    // Update profile event listener
    document.getElementById('profileForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const updatedFirstName = document.getElementById('firstName').value;
        const updatedLastName = document.getElementById('lastName').value;

        fetch(`http://localhost:8080/api/students/${userId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                // Include authentication headers if necessary
            },
            body: JSON.stringify({
                firstName: updatedFirstName,
                lastName: updatedLastName
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            alert('Profile updated successfully!');
            // Perform additional actions on success, such as updating the UI
        })
        .catch(error => {
            console.error('Error updating profile:', error);
            alert('Failed to update profile: ' + error.message);
        });
    });
});
