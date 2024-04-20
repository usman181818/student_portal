document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('loginForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        console.log('Sending request to server with:', { username, password });

        fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        })
        .then(response => {
            console.log('Received response:', response);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();  // Parses the JSON response
        })
        .then(data => {
            console.log('Response data:', data);
            // Check the message property of the data object
            if (data.message === 'User authenticated successfully') {
                alert('Login successful!');
                sessionStorage.setItem('username', username);  // Save the username in sessionStorage
                sessionStorage.setItem('userId', data.userId); // Save the user ID in sessionStorage
                window.location.href = 'index.html';  // Redirect to the Home Page
            } else {
                throw new Error('Login failed with message: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to login: ' + error.message);
        });
    });
});
