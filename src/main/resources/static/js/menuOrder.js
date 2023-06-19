function init(){
    console.log('inside init');
    $(document).ready(function() {
      filterByTime();
});
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