var api = "http://localhost:8080/api/orders" ;
var min = 100;
var max = 122;
var tableNumber = Math.floor(Math.random() * (max - min + 1)) + min;
function init(){
    console.log('inside init');
            // Get all the number input elements
//    var quantityInputs = document.querySelectorAll('.quantity-input');
//
//    // Add event listener to each input element
//    quantityInputs.forEach(function(input) {
//      input.addEventListener('change', handleQuantityChange);
//    });
//
//    // Event handler for quantity change
//   var itemList = []; // Boş bir liste oluştur
//
//   function handleQuantityChange(event) {
//     var quantity = event.target.value; // Güncellenen miktar değerini al
//     var parentDiv = event.target.closest('.col-lg-6'); // Giriş elemanının üst div'ini al
//     var itemName = parentDiv.querySelector('span.cambria').textContent; // Öğenin başlığını al
//     var itemPrice = parentDiv.querySelector('span.price').textContent; // Öğenin fiyatını al
//     var currentDate = new Date();
//     var date = currentDate.toLocaleDateString('en-GB');
//
//     // Get the current time components
//     var currentTime = new Date().toLocaleTimeString('en-US', { hour12: false, hour: '2-digit', minute: '2-digit' });
//
////     var ingredients = parentDiv.querySelector('.fst-italic.cambria').textContent; // Öğenin içeriklerini al
//
//     // Değerleri bir nesne olarak sakla
//     var item = {
//       quantity: quantity,
//       name: itemName,
//       price: itemPrice,
//       date: date,
//       currentTime: currentTime
////       ingredients: ingredients
//     };
//
//     // Liste içine ekle
//     itemList.push(item);
//
//     // Güncellenen liste
//     console.log(itemList);
//   }


    $(document).ready(function() {
      filterByTime();
});
    $("#order").click( function () {
        console.log("Inside click of order");
        getSelectedItems();
    });
}
 // List to store selected items

function getSelectedItems() {
    var items = document.querySelectorAll('.quantity-input');
    var itemList = [];
    items.forEach(function(item) {
        var quantity = parseInt(item.value);
        if (quantity !== 0) {
            var parentDiv = item.closest('.col-lg-6');
            var itemName = parentDiv.querySelector('h5 span.cambria').textContent;
            var itemPriceElement = parentDiv.querySelector('h5 span.text-primary');
            var itemPriceText = itemPriceElement.textContent;
            var itemPrice = parseFloat(itemPriceText.substring(1));

            console.log(itemPrice);

            var currentDate = new Date();
            var year = currentDate.getFullYear();
            var month = String(currentDate.getMonth() + 1).padStart(2, '0');
            var day = String(currentDate.getDate()).padStart(2, '0');
            var date = year + '-' + month + '-' + day;

            console.log(date);

            var currentDate = new Date();
            var time = currentDate.toLocaleTimeString('en-US', { hour12: false, hour: '2-digit', minute: '2-digit', second: '2-digit' });
            var itemData = {

                itemName: itemName,
                quantity: quantity,
                date: date,
                time: time,
                itemPrice: itemPrice,
                tableNumber: tableNumber

            };

            itemList.push(itemData);
        }

    });
    localStorage.setItem('tableNumber', tableNumber);

    // Updated list of selected items
    console.log(itemList);
var message = "You ordered:\n";
for (var i = 0; i < itemList.length; i++) {
  var item = itemList[i];
  message += item.quantity + " " + item.itemName  + "\n";
}
for (var i = 0; i < itemList.length; i++) {
  var item = itemList[i];
  var orderJson = JSON.stringify(item);
  console.log(orderJson);
  $.ajax({
          url: api,
          type: "post",
          data: orderJson,    // json for request body
          contentType:"application/json; charset=utf-8",   // What we send to frontend
          dataType: "json",  // get back from frontend
          // success: function(customer, textStatus, jqXHR){
          success: function(order){
          console.log(order)
          },


                  fail: function (error) {
                    console.log('Error: ' + error);
                  }

              });

}
alert(message);

    resetInputs();
}
function resetInputs() {
  var inputs = document.querySelectorAll('.quantity-input');

  for (var i = 0; i < inputs.length; i++) {
    var input = inputs[i];
    var value = parseInt(input.value);

    if (value !== 0) {
      input.value = 0;
    }
  }
}

function filterByTime() {
  var currentTime = localStorage.getItem("currentTime"); // Get the current hour
    var breakfastItem = document.getElementById("breakfast");
    var lunchItem = document.getElementById("lunch");
    var dinnerItem = document.getElementById("dinner");
    breakfastItem.style.display = "block";
    lunchItem.style.display = "block";
    dinnerItem.style.display = "block";

  // Define the time intervals for filtering
  var breakfastStart = 7; // Breakfast start time
  var breakfastEnd = 11; // Breakfast end time
  var lunchStart = 11; // Lunch start time
  var lunchEnd = 16; // Lunch end time
  var dinnerStart = 16; // Dinner start time
  var dinnerEnd = 21; // Dinner end time

  // Disable the links based on the current time
  if (currentTime < breakfastStart || currentTime >= breakfastEnd) {
    document.getElementById("breakfast").setAttribute("disabled", "disabled");
  }
  if (currentTime < lunchStart || currentTime >= lunchEnd) {
    document.getElementById("lunch").setAttribute("disabled", "disabled");
  }
  if (currentTime < dinnerStart || currentTime >= dinnerEnd) {
    document.getElementById("dinner").setAttribute("disabled", "disabled");
  }
}
function convertDateFormat(dateString) {
       const parts = dateString.split("/");
       const formattedDate = parts[2] + "-" + parts[1] + "-" + parts[0];
       return formattedDate;
     }
//function filterByTime() {
//  var currentTime = localStorage.getItem("currentTime"); // Get the saved current hour
//
//  // Define the time intervals for filtering
//  var breakfastStart = 7; // Breakfast start time
//  var breakfastEnd = 12; // Breakfast end time
//  var lunchStart = 12; // Lunch start time
//  var lunchEnd = 16; // Lunch end time
//  var dinnerStart = 17; // Dinner start time
//  var dinnerEnd = 21; // Dinner end time
//
//  var breakfastItem = document.getElementById("breakfast");
//  var lunchItem = document.getElementById("lunch");
//  var dinnerItem = document.getElementById("dinner");
//
//  // Hide all menu items by default
//  breakfastItem.style.display = "block";
//  lunchItem.style.display = "block";
//  dinnerItem.style.display = "block";
//
//  // Show the corresponding menu item based on the current time
//  if (currentTime >= breakfastStart && currentTime < breakfastEnd) {
//    breakfastItem.style.display = "block";
//  } else if (currentTime >= lunchStart && currentTime < lunchEnd) {
//    lunchItem.style.display = "block";
//  } else if (currentTime >= dinnerStart && currentTime < dinnerEnd) {
//    dinnerItem.style.display = "block";
//  }
//}