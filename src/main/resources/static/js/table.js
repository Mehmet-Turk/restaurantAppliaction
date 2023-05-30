var api = "http://localhost:8080/api/table" ;
var tableTable;
function init(){
    console.log('inside init' );
    $("#newTableButton").click( function () {
        console.log("Inside click of newTableButton");
        $('#tableModal').modal('show');
    });

    $("#editTableButton").click( function () {
        console.log("Inside click of editTableButton");
        // Get the data from selected row and fill fields in modal

        if (tableTable.row($('.selected')).data() == undefined) {
            alert("Select table first");
        }else{
            var table = tableTable.row($('.selected')).data();
            //alert(customer.id);
            $("#id").val(table.tableId);
            $("#number").val(table.tableNumber);
            $("#seat").val(table.seat);
            $("#mergeable").val(table.mergeable);
            $("#available").val(table.available);

            $('#tableModal').modal('show');
        }

    });

    $("#deleteTableButton").click( function () {
        console.log("Inside click of deleteTableButton");

        if (tableTable.row($('.selected')).data() == undefined) {
            alert("Select table first");
        }else{
            $('#tableDeleteModal').modal('show');
        }

    });

    // Button in modal
    $("#deleteTableConfirmButton").click( function () {
        console.log("Inside click of deleteTableConfirmButton");
        deleteTable();
        $('#tableDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#tableForm").on('submit', function() {
        console.log("Submitting");
        createTable();
        $('#tableModal').modal('hide');
    });

    initTableTable();
    // Get customers from backend and and update table
    getTableData();
}
function initTableTable() {

    console.log('inside initTableTable' );

    // Create columns (with titles) for datatable: id, tableNumber, seat, mergeable, available
    columns = [
        { "title":  "Table ID",//@todo
            "data": "tableId" ,
            "visible": false },
        { "title":  "Number",
            "data": "tableNumber" },
        { "title":  "Seat",
            "data": "seat" },
        { "title": "Mergeable",
            "data": "mergeable",
            "render": function(mergeable) {
            console.log(mergeable);
                 if (mergeable == true) {
                          return "Yes"
                            } else {
                                return "No"
                            }
                        }},
        { "title": "Available",
            "data": "available",
              "render": function(available) {
                                        if (available == true) {
                                            return "Yes"
                                        } else {
                                            return "No"
                                        }
                                    }}
    ];

    // Define new table with above columns
    tableTable = $("#tableTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#tableTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            tableTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}
function getTableData(){

    console.log('inside getTableData' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(tables){

 //           console.log('Data: ' + customers );

            if (tables) {
                tableTable.clear();
                tableTable.rows.add(tables);
                tableTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}
function createTable(){

    console.log('inside createTable' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var tableData = {
            tableId: $("#id").val(),
            tableNumber: $("#number").val(),
            seat: $("#seat").val(),
            mergeable: $("#mergeable").val(),
            available: $("#available").val()
    }

    // Transform Javascript object to json
    var tableJson = JSON.stringify(tableData);

    console.log(tableJson);

    $.ajax({
        url: api,
        type: "post",
        data: tableJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(table){

          console.log(table);

          // Clear fields in page
          $("#id").val('');
          $("#number").val('');
          $("#seat").val('');
          $("#mergeable").val('');
          $("#available").val('');

          // Refresh table data
          getTableData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
function deleteTable(){

    if (tableTable.row($('.selected')).data() == undefined) {
        alert("Select table first");
    }else{
        var table = tableTable.row($('.selected')).data();

        console.log(api + '/' + table.tableId);

            $.ajax({
                url: api + '/' + table.tableId,
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getTableData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}