var api = "http://localhost:8080/api/menu" ;
var itemTable;
function init(){
    console.log('inside init' );
    $("#newTableButton").click( function () {
        console.log("Inside click of newTableButton");
        $("#mainContent").hide();
        $('#tableModal').modal('show');
    });

    $("#editTableButton").click( function () {
        console.log("Inside click of editTableButton");
        // Get the data from selected row and fill fields in modal

        if (itemTable.row($('.selected')).data() == undefined) {
            alert("Select table first");
        }else{
            var menuItem = itemTable.row($('.selected')).data();
            //alert(customer.id);
            $("#id").val(menuItem.menuItemId);
            $("#name").val(menuItem.itemName);
            $("#type").val(menuItem.type);
            $("#ingredients").val(menuItem.ingredients);
            $("#price").val(menuItem.price);
            $("#alcoholic").val(menuItem.alcoholic);
            $("#mainContent").hide();
            $('#tableModal').modal('show');
        }

    });

    $("#deleteTableButton").click(function() {
        console.log("Inside click of deleteTableButton");

        if (itemTable.row($('.selected')).data() == undefined) {
            alert("Select table first");
        } else {
            $("#mainContent").hide();
            $('#tableDeleteModal').modal('show');
        }
    });

    $("#closeButton").click(function() {
        $('#tableModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    $("#closeButtonCancel").click(function() {
        $('#tableModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    // Button in modal
    $("#deleteTableConfirmButton").click(function() {
        console.log("Inside click of deleteTableConfirmButton");
        deleteTable();
        $('#tableDeleteModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });



    // Add submit event to form for new and edit
    $("#tableForm").on('submit', function() {
        console.log("Submitting");
        createTable();
        $('#tableModal').modal('hide');
    });

    initItemTable();
    // Get customers from backend and and update table
    getTableData();
}
function initItemTable() {

    console.log('inside initItemTable' );

    // Create columns (with titles) for datatable: id, tableNumber, seat, mergeable, available
    columns = [
        { "title":  "ID",//@todo
            "data": "menuItemId" ,
            "visible": false },
        { "title":  "ItemName",
            "data": "itemName" },
        { "title":  "Type",
            "data": "type" },
         { "title":  "ingredients",
            "data": "ingredients" },
         { "title":  "Price",
             "data": "price" },
        { "title": "Alcoholic",
            "data": "alcoholic",
            "render": function(alcoholic) {
            console.log(alcoholic);
                 if (alcoholic == true) {
                          return "Yes"
                            } else {
                                return "No"
                            }
                        }}
//                        ,
//                                { "title": "Available",
//                                    "data": "available",
//                                      "render": function(available) {
//                                                                if (available == true) {
//                                                                    return "Yes"
//                                                                } else {
//                                                                    return "No"
//                                                                }
//                                                            }}
    ];

    // Define new table with above columns
    itemTable = $("#itemTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#itemTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            itemTable.$('tr.selected').removeClass('selected');
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
        success: function(items){

           console.log('Data: ' + items );

            if (items) {
                itemTable.clear();
                itemTable.rows.add(items);
                itemTable.columns.adjust().draw();
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
            menuItemId: $("#id").val(),
            itemName: $("#name").val(),
            type: $("#type").val(),
            ingredients: $("#ingredients").val(),
            price: $("#price").val(),
            alcoholic: $("#alcoholic").val()
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
        success: function(items){
        alert("Item is created");

          console.log(table);

          // Clear fields in page
          $("#id").val('');
          $("#name").val('');
          $("#type").val('');
          $("#ingredients").val('');
          $("#price").val('');
          $("#alcoholic").val('');

          // Refresh table data
          getTableData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
function deleteTable(){

    if (itemTable.row($('.selected')).data() == undefined) {
        alert("Select item first");
    }else{
        var menuItem = itemTable.row($('.selected')).data();

        console.log(api + '/' + menuItem.menuItemId);

            $.ajax({
                url: api + '/' + menuItem.menuItemId,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){
                   alert("Item is deleted");
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