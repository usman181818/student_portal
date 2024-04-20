document.addEventListener('DOMContentLoaded', function() {
    const userId = sessionStorage.getItem('userId');
    if (!userId) {
        alert('You must be logged in to check graduation eligibility.');
        window.location.href = 'login.html';
        return;
    }

    fetch(`http://localhost:8080/api/students/${userId}/graduation-eligibility`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const messageContainer = document.getElementById('eligibilityMessage');
            messageContainer.textContent = data.message;
            messageContainer.style.color = data.eligible ? 'green' : 'red';
        })
        .catch(error => {
            console.error('Error fetching graduation eligibility:', error);
            alert('Error fetching graduation eligibility information.');
        });
});
