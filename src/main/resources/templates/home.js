document.addEventListener('DOMContentLoaded', function() {
    // Sign Out Event
    document.getElementById('signOut').addEventListener('click', function() {
        sessionStorage.clear(); // Clear all session storage data
        window.location.href = 'login.html'; // Redirect to Login Page
    });

    // Display Logged In Username
    const username = sessionStorage.getItem('username'); // Retrieve username from session storage
    if (username) {
        document.getElementById('usernameDisplay').textContent = username;
    } else {
        window.location.href = 'login.html'; // Redirect to login page if not logged in
    }
});
