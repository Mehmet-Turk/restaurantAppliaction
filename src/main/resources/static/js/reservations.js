var api = "http://localhost:8080/api/reservation" ;
var reservationsTable;
function init(){
    console.log('inside init' );

    $("#newReservationButton").click( function () {
        console.log("Inside click of newReservationButton");
        $('#reservationsModal').modal('show');
    });

    $("#editReservationButton").click( function () {
        console.log("Inside click of editReservationButton");
        // Get the data from selected row and fill fields in modal

            if (reservationsTable.row($('.selected')).data() == undefined) {
                alert("Select reservations first");
            }else{
                var reservations = reservationsTable.row($('.selected')).data();
                //alert(customer.id);
//                $("#id").val(reservation.reservationId);
//                $("#id2").val(reservation.customer.customerId);
                $("#firstName").val(reservations.customer.firstName);
                $("#lastName").val(reservations.customer.lastName);
                $("#phoneNumber").val(reservations.customer.phoneNumber);
//                $("#email").val(reservation.customer.email);
//                $("#adress").val(reservation.customer.adress);
//                $("#guest").val(reservation.customer.guest);
//
//                $("#id3").val(reservation.table.tableId);
//                $("#tableNumber").val(reservation.table.tableNumber);
//                $("#seat").val(reservation.table.seat);
//                $("#mergeable").val(reservation.table.mergeable);
//                $("#avaible").val(reservation.table.available);
//
                $("#date").val(reservations.date);
                $("#time").val(reservations.time);
//
//                $("#addBabyChair").val(reservation.addBabyChair);

                $('#reservationsModal').modal('show');
            }

        });

    $("#deleteReservationButton").click( function () {
        console.log("Inside click of deleteReservationButton");

        if (reservationsTable.row($('.selected')).data() == undefined) {
            alert("Select reservations first");
        }else{
            $('#reservationDeleteModal').modal('show');
        }

    });

    // Button in modal
    $("#deleteReservationConfirmButton").click( function () {
        console.log("Inside click of deleteReservationConfirmButton");
        deleteReservation();
        $('#reservationDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#reservationForm").on('submit', function() {
        console.log("Submitting");
        createReservation();
        $('#reservationModal').modal('hide');
    });

    initReservationsTable();
    // Get customers from backend and and update stock
    getReservationsData();
}
function initReservationsTable() {

    console.log('inside initStockTable' );

    // Create columns (with titles) for datatable: id, name, recentAmount, minAmount
    columns = [
        { "title":  "Reservation ID",//@todo
            "data": "reservationId" ,
            "visible": false },
        { "title":  "First Name",
            "data": "customer.firstName" },
        { "title":  "Last Name",
            "data": "customer.lastName" },
        { "title":  "Phone Number",
            "data": "customer.phoneNumber" },
        { "title":  "E-mail",
           "data": "customer.email" },
        { "title":  "Address",
           "data": "customer.address" },
        { "title":  "Date",
            "data": "date" },
        { "title":  "Time",
            "data": "time" },
        { "title":  "BabyChair",
            "data": "addBabyChair" }

//        { "title":  "RecentAmount",
//            "data": "recentAmount" },
//        { "title": "MinAmount",
//            "data": "minAmount"}
//            "render": function(mergeable) {
//            console.log(mergeable);
//                 if (mergeable == true) {
//                          return "Yes"
//                            } else {
//                                return "No"
//                            }
//                        }},
//        { "title": "Available",
//            "data": "available",
//              "render": function(available) {
//                                        if (available == true) {
//                                            return "Yes"
//                                        } else {
//                                            return "No"
//                                        }
//                                    }}
    ];

    // Define new table with above columns
    reservationsTable = $("#reservationsTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#reservationsTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            reservationsTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

function getReservationsData(){

    console.log('inside getReservationData' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(reservations){

 //           console.log('Data: ' + customers );

            if (reservations) {
                reservationsTable.clear();
                reservationsTable.rows.add(reservations);
                reservationsTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}
//function createReservations(){
//
//    console.log('inside createReservations' );
//
//    // Put customer data from page in Javascript object --- SIMILAR TO JSON
//    var reservationsData = {
//            reservationsId: $("#id").val(),
//            reservations.customerId: $("#id2").val(),
//            firstName: $("#name").val(),
//            recentAmount: $("#recentAmount").val(),
//            minAmount: $("#minAmount").val()
//    }
//
//    // Transform Javascript object to json
//    var stockJson = JSON.stringify(stockData);
//
//    console.log(stockJson);
//
//    $.ajax({
//        url: api,
//        type: "post",
//        data: stockJson,    // json for request body
//        contentType:"application/json; charset=utf-8",   // What we send to frontend
//        dataType: "json",  // get back from frontend
//        // success: function(customer, textStatus, jqXHR){
//        success: function(stock){
//
//          console.log(stock);
//
//          // Clear fields in page
//          $("#id").val('');
//          $("#name").val('');
//          $("#recentAmount").val('');
//          $("#minAmount").val('');
//
//          // Refresh stock data
//          getStockData();
//
//        },
//
//        fail: function (error) {
//          console.log('Error: ' + error);
//        }
//
//    });
//
//}

//function deleteStock(){
//
//    if (stockTable.row($('.selected')).data() == undefined) {
//        alert("Select stock first");
//    }else{
//        var stock = stockTable.row($('.selected')).data();
//
//        console.log(api + '/' + stock.stockId);
//
//            $.ajax({
//                url: api + '/' + stock.stockId,
//                type: "delete",
//                contentType: "application/json",
//                dataType: "text",  // get back from frontend
//                // success: function(customer, textStatus, jqXHR){
//                success: function(message){
//
//                  console.log(message);
//
//                  // Refresh table data
//                  getStockData();
//
//                },
//
//                fail: function (error) {
//                  console.log('Error: ' + error);
//                }
//
//            });
//
//
//
//    }
//
//
//}