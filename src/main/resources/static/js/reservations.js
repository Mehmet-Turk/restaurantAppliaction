var api = "http://localhost:8080/api/reservation" ;
var reservationsTable;
function init(){
    console.log('inside init' );

    $("#newReservationButton").click( function () {
        console.log("Inside click of newReservationButton");
        $("#mainContent").hide();
        $('#reservationsModal').modal('show');

    });

    $("#editReservationButton").click( function () {
        console.log("Inside click of editReservationButton");
        // Get the data from selected row and fill fields in modal

            if (reservationsTable.row($('.selected')).data() == undefined) {
                alert("Select reservations first");
            }else{
                var reservation = reservationsTable.row($('.selected')).data();
                //alert(customer.id);
                $("#id").val(reservation.reservationId);
//                $("#customerId").val(reservation.customer.customerId);
                $("#fullName").val(reservation.fullName);
//                $("#lastName").val(reservation.customer.lastName);
                $("#phoneNumber").val(reservation.phoneNumber);
                $("#email").val(reservation.email);
                $("#numberOfPeople").val(reservation.numberOfPeople);
                $("#date").val(reservation.date);
                $("#time").val(reservation.time);
                $("#roomNumber").val(reservation.roomNumber);
                $("#addBabyChair").val(reservation.addBabyChair);
                $("#mainContent").hide();
                $('#reservationsModal').modal('show');

            }

        });

    $("#deleteReservationButton").click( function () {
        console.log("Inside click of deleteReservationButton");

        if (reservationsTable.row($('.selected')).data() == undefined) {
            alert("Select reservation first");
        }else{
            $("#mainContent").hide();
            $('#reservationDeleteModal').modal('show');

        }
    });
    $("#closeButton").click(function() {
        $('#reservationsModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });
        $("#closeButtonCancel").click(function() {
            $('#reservationsModal').modal('hide');

            // Show the main content
            $("#mainContent").show();
        });
    // Button in modal
//    $("#deleteReservationConfirmButton").click( function () {
//        $("#mainContent").modal('show');
//        console.log("Inside click of deleteReservationConfirmButton");
//        deleteReservation();
//        $('#reservationDeleteModal').modal('hide');
//
//    });
$("#deleteReservationConfirmButton").click(function() {
    console.log("Inside click of deleteReservationConfirmButton");
    deleteReservation();
    $('#reservationDeleteModal').modal('hide');

    // Show a loading overlay on the main content
    var loadingOverlay = $('<div class="loading-overlay"></div>');
    $("#mainContent").append(loadingOverlay);

    // Wait for a short duration before showing the main content again
    setTimeout(function() {
        loadingOverlay.remove();
        $("#mainContent").modal('show');
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    }); // Adjust the delay as needed
});


    // Add submit event to form for new and edit
    $("#reservationForm").on('submit', function() {
        console.log("Submitting");
        createReservation();
        $('#reservationModal').modal('hide');
    });

    initReservationsTable();
    // Get reservations from backend and and update reservation
    getReservationsData();closeButton

}
function initReservationsTable() {

    console.log('inside initReservationsTable' );

    // Create columns (with titles) for datatable: reservationId, customerId, firstName, lastName...
    columns = [
        { "title":  "Reservation ID",
            "data": "reservationId" ,
            "visible": false },
        { "title":  "Name",
            "data": "fullName" },
//        { "title":  "Last Name",
//            "data": "customer.lastName" },
        { "title":  "Phone Number",
            "data": "phoneNumber" },
        { "title":  "E-mail",
           "data": "email" },
//        { "title":  "Address",
//           "data": "customer.address" },
        { "title":  "Number Of People",
            "data": "numberOfPeople" },
        { "title":  "Date",
            "data": "date" },
        { "title":  "Time",
            "data": "time" },
        { "title":  "Room Number",
            "data": "roomNumber" },
            { "title":  "Table Number",
                        "data": "table[,].tableNumber"},
        { "title":  "BabyChair",
            "data": "addBabyChair",
            "render": function(addBabyChair) {
            console.log(addBabyChair);
                if (addBabyChair == true) {
                        return "Yes"
                           } else {
                              return "No"
                                }
                           }}
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

            console.log('Data: ' +reservations );

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
function createReservation(){

    console.log('inside createReservation' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var reservationsData = {
            reservationId: $("#id").val(),
//            customer: {
//                customerId: $("#customerId").val(),
//                firstName: $("#firstName").val(),
//                lastName: $("#lastName").val(),
//                phoneNumber: $("#phoneNumber").val(),
//                email: $("#email").val(),
//                address: $("#address").val(),
//            },
            restaurantTables:{
            tableId: $("#tableId").val(),
            seat: $("#seat").val(),
            },
            fullName: $("#fullName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            numberOfPeople: $("#numberOfPeople").val(),
            roomNumber: $("#roomNumber").val(),
            date: $("#date").val(),
            time: $("#time").val(),
            addBabyChair: $("#addBabyChair").val()
    }

    // Transform Javascript object to json
    var reservationsJson = JSON.stringify(reservationsData);

    console.log(reservationsJson);

    $.ajax({
        url: api,
        type: "post",
        data: reservationsJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(reservations){

          console.log(reservations);

          // Clear fields in page
          $("#id").val('');
          $("#fullName").val('');
//          $("#lastName").val('');
          $("#phoneNumber").val('');
          $("#email").val('');
          $("#numberOfPeople").val('');
          $("#date").val('');
          $("#time").val('');
          $("#roomNumber").val('');
          $("#addBabyChair").val('');
          $("#seat").val('');

          // Refresh stock data
          getReservationsData();


        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function deleteReservation(){

    if (reservationsTable.row($('.selected')).data() == undefined) {
        alert("Select stock first");
    }else{
        var reservations = reservationsTable.row($('.selected')).data();

        console.log(api + '/' + reservations.reservationId);

            $.ajax({
                url: api + '/' + reservations.reservationId,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getReservationsData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}