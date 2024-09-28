// Email validation function
function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}


// Phone validation function
function validatePhone(phone) {
    const re = /^[0-9]{10}$/;  // Adjust regex to match your needs
    return re.test(phone);
}


// Add event listener for signup form submission
document.getElementById('signupForm').addEventListener('submit', function(event) {
    const email = document.getElementById('email').value.trim();
    const phone = document.getElementById('tel').value.trim();
    const isValidEmail = validateEmail(email);
    const isValidPhone = validatePhone(phone);

    if (!isValidEmail || !isValidPhone) {
        alert('Invalid input');
        event.preventDefault();  // Stop form submission
    }

    //AJAX
    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: JSON.stringify({
            email: email,
            phone: phone,
        }),
        headers: { 'Content-Type': 'application/json' }
    }).then(response => response.json())
      .then(data => console.log(data));
});
