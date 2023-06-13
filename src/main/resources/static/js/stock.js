var api = "http://localhost:8080/api/stock" ;
var stockTable;
function init(){
    console.log('inside init' );


    $("#newStockButton").click( function () {
        console.log("Inside click of newStockButton");
        $("#mainContent").hide();
        $('#stockModal').modal('show');
    });

    $("#editStockButton").click( function () {
        console.log("Inside click of editStockButton");
        // Get the data from selected row and fill fields in modal

            if (stockTable.row($('.selected')).data() == undefined) {
                alert("Select stock first");
            }else{
                var stock = stockTable.row($('.selected')).data();
                //alert(customer.id);
                $("#id").val(stock.stockId);
                $("#name").val(stock.name);
                $("#recentAmount").val(stock.recentAmount);
                $("#minAmount").val(stock.minAmount);
                $("#mainContent").hide();
                $('#stockModal').modal('show');
            }

        });

    $("#deleteStockButton").click(function() {
        console.log("Inside click of deleteStockButton");

        if (stockTable.row($('.selected')).data() == undefined) {
            alert("Select stock first");
        } else {
            $("#mainContent").hide();
            $('#stockDeleteModal').modal('show');
        }
    });

    $("#closeButton").click(function() {
        $('#stockModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    $("#closeButtonCancel").click(function() {
        $('#stockModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    // Button in modal
    $("#deleteStockConfirmButton").click(function() {
        console.log("Inside click of deleteStockConfirmButton");
        deleteStock();
        $('#stockDeleteModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    // Add submit event to form for new and edit
    $("#stockForm").on('submit', function() {
        console.log("Submitting");
        createStock();
        $('#stockModal').modal('hide');
    });

    initStockTable();
    // Get customers from backend and and update stock
    getStockData();
}
function initStockTable() {

    console.log('inside initStockTable' );

    // Create columns (with titles) for datatable: id, name, recentAmount, minAmount
    columns = [
        { "title":  "Stock ID",//@todo
            "data": "stockId" ,
            "visible": false },
        { "title":  "Name",
            "data": "name" },
        { "title":  "RecentAmount",
            "data": "recentAmount" },
        { "title": "MinAmount",
            "data": "minAmount"}
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
    stockTable = $("#stockTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#stockTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            stockTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

function getStockData(){

    console.log('inside getStockData' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(stocks){

 //           console.log('Data: ' + customers );

            if (stocks) {
                stockTable.clear();
                stockTable.rows.add(stocks);
                stockTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}
function createStock(){

    console.log('inside createStock' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var stockData = {
            stockId: $("#id").val(),
            name: $("#name").val(),
            recentAmount: $("#recentAmount").val(),
            minAmount: $("#minAmount").val()
    }

    // Transform Javascript object to json
    var stockJson = JSON.stringify(stockData);

    console.log(stockJson);

    $.ajax({
        url: api,
        type: "post",
        data: stockJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(stock){

          console.log(stock);

          // Clear fields in page
          $("#id").val('');
          $("#name").val('');
          $("#recentAmount").val('');
          $("#minAmount").val('');

          // Refresh stock data
          getStockData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function deleteStock(){

    if (stockTable.row($('.selected')).data() == undefined) {
        alert("Select stock first");
    }else{
        var stock = stockTable.row($('.selected')).data();

        console.log(api + '/' + stock.stockId);

            $.ajax({
                url: api + '/' + stock.stockId,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getStockData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}