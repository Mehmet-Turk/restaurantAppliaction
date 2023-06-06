function validateForm(event) {
  event.preventDefault();

  var emailInput = document.getElementById('email');
  var notification = document.createElement('div');
  notification.className = 'notification';
  document.body.appendChild(notification);

  var email = emailInput.value.trim();

  if (email === '') {
    notification.innerText = 'Please enter your e-mail address!';
    notification.classList.add('show');
  } else if (!email.includes('@') || email.split('@')[1].split('.').length !== 2 || email.split('@')[1].split('.')[1] !== 'com') {
    notification.innerText = 'Please enter a valid e-mail address!';
    notification.classList.add('show');
  } else {
    notification.innerText = 'New password has been sent!';
    notification.classList.add('show');
    notification.classList.add('green'); // Add 'green' class for green background
  }

  emailInput.value = ''; // Reset email input

  setTimeout(function () {
    notification.classList.remove('show');
    notification.classList.remove('green'); // Remove 'green' class after timeout
  }, 3000);
}
