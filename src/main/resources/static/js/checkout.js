var api = "http://localhost:8080/api/orders/filter";

function showMessage() {
  var notification = document.createElement('div');
  notification.className = 'notification';
  notification.innerText = 'Waiter is coming, please wait';
  notification.style.backgroundColor = '#fea116';

  // Add 'position: fixed' to make the notification fixed on the page
  notification.style.position = 'none';

  document.body.appendChild(notification);
  event.preventDefault();

  setTimeout(function() {
    notification.classList.add('show');
  }, 100);

  // Calculate the position relative to the viewport
  var viewportWidth = window.innerWidth || document.documentElement.clientWidth;
  var viewportHeight = window.innerHeight || document.documentElement.clientHeight;
  var notificationWidth = notification.offsetWidth;
  var notificationHeight = notification.offsetHeight;

  var topPosition = viewportHeight / 2 - notificationHeight / 2 + 'px';
  var leftPosition = viewportWidth * 0.3 - notificationWidth / 2 + 'px';

  notification.style.top = topPosition;
  notification.style.left = leftPosition;

   setTimeout(function() {
     notification.classList.remove('show');
     setTimeout(function() {
       notification.remove();
     }, 1000);
   }, 2000);
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
  setTimeout(function() {
    notification.classList.remove('show');
    setTimeout(function() {
      notification.remove();
    }, 1000);
  }, 2000);
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
  setTimeout(function() {
    notification.classList.remove('show');
    setTimeout(function() {
      notification.remove();
    }, 1000);
  }, 2000);
}

function displayOrders() {
  var tableNumber = parseInt(localStorage.getItem('tableNumber'));
  var data = {
    tableNumber: tableNumber
  };
  var jsonData = JSON.stringify(data);
  console.log(jsonData)

  $.ajax({
    url: api,
    type: "post",
    data: jsonData,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function(info) {
      console.log(info);
      var orders = info;
      localStorage.setItem('orders', JSON.stringify(info));

      // Create the content for the popup window
      var content = "<html><head><title>Order Information</title>";
      content += "<style>body {";
      content += "  background-image: url('img/Company_Logo-removebg-previewr.png');";
      content += "  background-repeat: no-repeat;";
      content += "  background-size: cover;";
      content += "  background-position: center;";
      content += "  background-color: rgba(0, 0, 0, 0.05);"; // Adjust transparency here
      content += "}</style>";
      content += "<style>.blur { filter: blur(4px); }</style>";
      content += "</head><body>";

      // Generate the table with order information
      content += "<table>";
      content += "<thead><tr><th>Orders</th><th>Qty</th><th>Price</th></tr></thead>";
      content += "<tbody>";

      var totalPrice = 0;

      orders.forEach(function(order) {
        var itemName = order.itemName;
        var quantity = order.quantity;
        var itemPrice = order.itemPrice;

        // Calculate the total price
        var orderPrice = quantity * itemPrice;
        totalPrice += orderPrice;

        // Create a new row
        content += "<tr>";
        content += "<td>" + itemName + "</td>";
        content += "<td>" + quantity + "</td>";
        content += "<td>" + itemPrice + "</td>";
        content += "</tr>";
      });

      content += "</tbody></table>";

      // Display the total price
      content += "<p>Total Price: " + totalPrice + "$" + "</p>";

      // Close button
      content += "<button onclick='window.close()'>Close</button>";

      content += "<script>window.addEventListener('beforeunload', function() { window.opener.document.body.classList.remove('blur'); });</script>";

      content += "</body></html>";

      // Open a new popup window
      var screenWidth = window.screen.width;
      var screenHeight = window.screen.height;
      var popupWidth = 350;
      var popupHeight = 400;
      var leftPosition = (screenWidth - popupWidth) / 2;
      var topPosition = (screenHeight - popupHeight) / 2;

      var popup = window.open("", "Order Information", "width=" + popupWidth + ",height=" + popupHeight + ",left=" + leftPosition + ",top=" + topPosition);
      popup.document.open();
      popup.document.write(content);
      popup.document.close();

      // Blur the main page
      document.body.classList.add('blur');
      localStorage.removeItem('orders');
      localStorage.removeItem('tableNumber');
    },
    error: function(jqXHR, textStatus, errorThrown) {
      console.log('Error: ' + errorThrown);
    }
  });
}


// Add click event listener to the button
//var displayOrdersBtn = document.querySelector("#displayOrdersBtn");
//displayOrdersBtn.addEventListener("click", displayOrders);


