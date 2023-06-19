    // // initialize the total price to 0
    //         let totalPrice = 0;

    //         // function to increment quantity and update total price
    //         function increment(id) {
    //             const qtyEl = document.getElementById(id);
    //             const totalEl = document.getElementById(`total-${id.split('-')[1]}`);
    //             const price = parseInt(qtyEl.parentNode.previousElementSibling.textContent.substring(1));
    //             let qty = parseInt(qtyEl.textContent);
    //             qty++;
    //             qtyEl.textContent = qty;
    //             const total = price * qty;
    //             totalEl.textContent = total;
    //             totalPrice += price;
    //             document.getElementById('total-price').textContent = totalPrice;
    //         }

    //         // function to decrement quantity and update total price
    //         function decrement(id) {
    //             const qtyEl = document.getElementById(id);
    //             const totalEl = document.getElementById(`total-${id.split('-')[1]}`);
    //             const price = parseInt(qtyEl.parentNode.previousElementSibling.textContent.substring(1));
    //             let qty = parseInt(qtyEl.textContent);
    //             if (qty > 0) {
    //                 qty--;
    //                 qtyEl.textContent = qty; const total = price * qty;
    //                 totalEl.textContent = total;
    //                 totalPrice -= price;
    //                 document.getElementById('total-price').textContent = totalPrice;
    //             }
    //         }

       // Select all the necessary elements
//        const prices = document.querySelectorAll('.price');
//        const quantityInputs = document.querySelectorAll('.quantity-input');
//        const decreaseBtns = document.querySelectorAll('.decrease-btn');
//        const increaseBtns = document.querySelectorAll('.increase-btn');
//        const total = document.querySelector('.total-price');
//        const quantityInfo = document.getElementById('quantity-information'); // Select the element to display the information
//
//        let totalPrice = 0;
//
//        // Function to update the total price and quantity information
//        function updateTotalPrice() {
//            totalPrice = 0;
//            for (let i = 0; i < prices.length; i++) {
//                totalPrice += parseInt(prices[i].textContent.replace('$', '')) * parseInt(quantityInputs[i].value);
//            }
//            total.textContent = '$' + totalPrice;
//
//            // Update quantity information
//            let info = '';
//            for (let i = 0; i < quantityInputs.length; i++) {
//                if (quantityInputs[i].value != 0) {
//
//                    info += `Quantity input at index ` + (i + 1) + ` has value ${quantityInputs[i].value}.<br>`;
//                }
//            }
//            quantityInfo.innerHTML = info;
//        }
//
//        // Add event listeners to the buttons and inputs
//        for (let i = 0; i < decreaseBtns.length; i++) {
//            decreaseBtns[i].addEventListener('click', function () {
//                if (quantityInputs[i].value > 0) {
//                    quantityInputs[i].value--;
//                    updateTotalPrice();
//                }
//            });
//        }
//
//        for (let i = 0; i < increaseBtns.length; i++) {
//            increaseBtns[i].addEventListener('click', function () {
//                quantityInputs[i].value++;
//                updateTotalPrice();
//            });
//        }
//
//        for (let i = 0; i < quantityInputs.length; i++) {
//            quantityInputs[i].addEventListener('input', function () {
//                if (quantityInputs[i].value < 0) {
//                    quantityInputs[i].value = 0;
//                }
//                updateTotalPrice();
//            });
//        }
// script.js dosyanız
// script.js

//function hideItemsByIds(ids) {
//  for (var i = 0; i < ids.length; i++) {
//    var itemId = ids[i];
//    var item = document.getElementById(itemId);
//    if (item) {
//      item.style.display = "none";
//    }
//  }
//}
//
//// Call the hideItemsByIds function with the IDs of the items you want to hide
//hideItemsByIds(["breakfast", "lunch", "dinner"]); // Replace "item1", "item2", "item3" with the actual IDs of the items you want to hide


function hideElements() {
  var elements = document.querySelectorAll(".input-group.ml-3, .btn.btn-primary.cambria.border");

  for (var i = 0; i < elements.length; i++) {
    elements[i].style.display = "none";
  }

  // Gizlenen elemanların durumunu kaydetmek için localStorage kullanımı
  localStorage.setItem("elementsHidden", "true");
}

// Sayfa yüklendiğinde gizlenen elemanların durumunu kontrol etme
window.onload = function() {
  var elementsHidden = localStorage.getItem("elementsHidden");
  if (elementsHidden === "true") {
    var elements = document.querySelectorAll(".input-group.ml-3, .btn.btn-primary.cambria.border");
    for (var i = 0; i < elements.length; i++) {
      elements[i].style.display = "none";
    }
  }
}


