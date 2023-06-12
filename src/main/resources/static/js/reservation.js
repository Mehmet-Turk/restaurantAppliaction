var api = "http://localhost:8080/api/reservation" ;
var apiTable = "http://localhost:8080/api/table/filter/true" ;
function init(){
    console.log('inside init');
//     $.ajax({
//                url: apiTable,
//                type: "get",
//                data:  true,
//                dataType: "json",
//                contentType:"application/json; charset=utf-8",   // What we send to frontend
//                // success: function(customers, textStatus, jqXHR){
//                success: function(tables){
//
//         //           console.log('Data: ' + customers );
//
//                    if (tables) {
//                        console.log(tables)
//                    }
//                },
//
//                fail: function (error) {
//                    console.log('Error: ' + error);
//                }
//
//            });

    $("#reservationForm").on('submit', function () {
        console.log("Inside submit of newReservationButton");

        createReservation();
        window.location.href = "/reservationDetails";
        event.preventDefault();

    });
}
function createReservation(){

    console.log('inside createReservation' );
    var addBabyChair = false;
    if($("#select1").val() == "Yes"){
     addBabyChair = true; }
     console.log($("#myDateInput").val());
     console.log($("#timeSelection").val());


     //date converter
     function convertDateFormat(dateString) {
       const parts = dateString.split("-");
       const formattedDate = parts[2] + "-" + parts[1] + "-" + parts[0];
       return formattedDate;
     }


     var formattedDate = convertDateFormat($("#myDateInput").val());
     console.log("Formatted Date:", formattedDate); // Output: "2023-06-20"
     var time = $(".timeBox.selected").text();

     var tel = $(".iti__selected-dial-code").text() + $("#phone").val();
     var numberOfPeople = $("#People").val();

     // Filter available tables based on the number of seats and whether they are mergeable






    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            date: formattedDate,
            //table: reservedTables,
            time: time,
            addBabyChair: addBabyChair,
            fullName: $("#name").val(),
            numberOfPeople: numberOfPeople,
            phoneNumber: tel,
            email: $("#email1").val(),
            roomNumber: $("#roomNumber").val()

    }

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);

    console.log(reservationJson);


    $.ajax({
        url: api,
        type: "post",
        data: reservationJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(res){
        localStorage.setItem('reservation', JSON.stringify(res));




        console.log(res);
//        displayReservationDetails(reservation);

        //window.location.href = "/reservationDetails";
//          res = reservation;


          // Clear fields in page
          $("#id").val('');
          $("#name").val('');
          $("#email1").val('');
          $("#phone").val('');
          $("#roomNumber").val('');
          $("#myDateInput").val('');
          //$("#timeSelection").val();
          $("#select1").val();

          // Refresh stock data
          //getStockData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}






