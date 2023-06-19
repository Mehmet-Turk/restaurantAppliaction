var api = "http://localhost:8080/api/menu" ;
var itemTable;
function init(){
    console.log('inside init' );
    $("#newItemButton").click( function () {
        console.log("Inside click of newItemButton");
        $("#mainContent").hide();
        $('#itemModal').modal('show');
    });

    $("#editItemButton").click( function () {
        console.log("Inside click of editItemButton");
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
            $('#itemModal').modal('show');
        }

    });

    $("#deleteItemButton").click(function() {
        console.log("Inside click of deleteItemButton");

        if (itemTable.row($('.selected')).data() == undefined) {
            alert("Select table first");
        } else {
            $("#mainContent").hide();
            $('#itemDeleteModal').modal('show');
        }
    });

    $("#closeButton").click(function() {
        $('#itemModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    $("#closeButtonCancel").click(function() {
        $('#itemModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    // Button in modal
    $("#deleteItemConfirmButton").click(function() {
        console.log("Inside click of deleteItemConfirmButton");
        deleteItem();
        $('#itemDeleteModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });



    // Add submit event to form for new and edit
    $("#itemForm").on('submit', function() {
        console.log("Submitting");
        createItem();
        $('#itemModal').modal('hide');
    });

    initItemTable();
    // Get customers from backend and and update table
    getItemData();
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
function getItemData(){

    console.log('inside getItemData' );
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
function createItem(){

    console.log('inside createItem' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var itemData = {
            menuItemId: $("#id").val(),
            itemName: $("#name").val(),
            type: $("#type").val(),
            ingredients: $("#ingredients").val(),
            price: $("#price").val(),
            alcoholic: $("#alcoholic").val()
    }

    // Transform Javascript object to json
    var itemJson = JSON.stringify(itemData);

    console.log(itemJson);

    $.ajax({
        url: api,
        type: "post",
        data: itemJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(items){
        alert("Item is created");

          console.log(item);

          // Clear fields in page
          $("#id").val('');
          $("#name").val('');
          $("#type").val('');
          $("#ingredients").val('');
          $("#price").val('');
          $("#alcoholic").val('');

          // Refresh table data
          getItemData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
function deleteItem(){

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
                  getItemData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}