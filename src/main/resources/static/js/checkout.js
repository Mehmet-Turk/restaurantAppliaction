function showMessage() {
  var notification = document.createElement('div');
  notification.className = 'notification';
  notification.innerText = 'Waiter is coming please wait';
  notification.style.backgroundColor = '#fea116';
  document.body.appendChild(notification);
  event.preventDefault();
  setTimeout(function() {
    notification.classList.add('show');
  }, 100);
  notification.style.top = 'calc(50% + 9px)';
  notification.style.left = 'calc(30% - 10px)';
//  setTimeout(function() {
//    notification.classList.remove('show');
//    setTimeout(function() {
//      notification.remove();
//    }, 10000);
//  }, 20000);
}


function showMessage1() {
  var notification = document.createElement('div');
  notification.className = 'notification';
  notification.innerText = 'Payment made successfully !';
  notification.style.backgroundColor = '#0ca116';
  document.body.appendChild(notification);
  event.preventDefault();
  setTimeout(function() {
    notification.classList.add('show');
  }, 100);
  notification.style.top = 'calc(50% + 9px)';
  notification.style.left = 'calc(30% - 10px)';
//  setTimeout(function() {
//    notification.classList.remove('show');
//    setTimeout(function() {
//      notification.remove();
//    }, 10000);
//  }, 20000);
}


function showMessage2() {
  var notification = document.createElement('div');
  notification.className = 'notification';
  notification.innerText = 'Payment made successfully !';
  notification.style.backgroundColor = '#0ca116';
  document.body.appendChild(notification);
  event.preventDefault();
  setTimeout(function() {
    notification.classList.add('show');
  }, 100);
  notification.style.top = 'calc(50% + 9px)';
  notification.style.left = 'calc(30% - 10px)';
//  setTimeout(function() {
//    notification.classList.remove('show');
//    setTimeout(function() {
//      notification.remove();
//    }, 10000);
//  }, 20000);
}
