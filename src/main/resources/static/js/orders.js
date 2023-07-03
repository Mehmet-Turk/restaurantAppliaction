var api = "http://localhost:8080/api/orders";
var orderTable;

function init() {
    console.log('inside init');
    $("#newOrderButton").click(function() {
        console.log("Inside click of newOrderButton");
        $("#mainContent").hide();
        $('#orderModal').modal('show');
    });

    $("#editOrderButton").click(function() {
        console.log("Inside click of editOrderButton");
        // Get the data from selected row and fill fields in modal

        if (orderTable.row($('.selected')).data() == undefined) {
            alert("Select order first");
        } else {
            var order = orderTable.row($('.selected')).data();
            $("#id").val(order.orderId);
            $("#itemName").val(order.itemName);
            $("#quantity").val(order.quantity);
            $("#date").val(order.date);
            $("#time").val(order.time);
            $("#tableNumber").val(order.tableNumber);
            $("#mainContent").hide();
            $('#orderModal').modal('show');
        }

    });

    $("#deleteOrderButton").click(function() {
        console.log("Inside click of deleteOrderButton");

        if (orderTable.row($('.selected')).data() == undefined) {
            alert("Select order first");
        } else {
            $("#mainContent").hide();
            $('#orderDeleteModal').modal('show');
        }
    });

    $("#closeButton").click(function() {
        $('#orderModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    $("#closeButtonCancel").click(function() {
        $('#orderModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });

    // Button in modal
    $("#deleteOrderConfirmButton").click(function() {
        console.log("Inside click of deleteOrderConfirmButton");
        deleteOrder();
        $('#orderDeleteModal').modal('hide');

        // Show the main content
        $("#mainContent").show();
    });



    // Add submit event to form for new and edit
    $("#orderForm").on('submit', function() {
        console.log("Submitting");
        createOrder();
        $('#orderModal').modal('hide');
    });

    initOrderTable();
    // Get customers from backend and and update table
    getOrderData();
}

function initOrderTable() {

    console.log('inside initOrderTable');

    // Create columns (with titles) for datatable: id, tableNumber, seat, mergeable, available
    columns = [{
            "title": "Order ID", //@todo
            "data": "orderId",
            "visible": false
        },
        {
            "title": "Item Name",
            "data": "itemName",
//            "render": function(menuItems) {
//                var itemNames = menuItems.map(function(menuItem) {
//                    return menuItem.itemName;
//                });
//                return itemNames.join("<br>");
//            }
        },
        {
            "title": "Date",
            "data": "date"
        },
        {
            "title": "Time",
            "data": "time"
        },
        {
             "title": "Quantity",
             "data": "quantity"
        },
        //            { "title":  "Item Name",
        //                        "data": "menuItem[,].itemName" },
//        {
//            "title": "price",
//            "data": "menuItem",
//            "render": function(menuItems) {
//                var prices = menuItems.map(function(menuItem) {
//                    return "$" + menuItem.price;
//                });
//                return prices.join("<br>");
//            }
//        },
        //        { "title":  "Type",
        //             "data": "menuItem[,].type" },
        //        { "title":  "Description",
        //             "data": "menuItem[,].description" },
//        {
//            "title": "Total Price",
//            "data": getTotalPrice
//        },
           {         "title": "Table Number",
                    "data": "tableNumber"
                }
        //        { "title": "Alcoholic",
        //            "data": "menuItem.alcoholic",
        //            "render": function(alcoholic) {
        //            console.log(alcoholic);
        //                 if (alcoholic == true) {
        //                          return "Yes"
        //                            } else {
        //                                return "No"
        //                            }
        //                        }}
    ];

    // Define new table with above columns
    orderTable = $("#orderTable").DataTable({
        "order": [
            [0, "asc"]
        ],
        "columns": columns
    });


    $("#orderTable tbody").on('click', 'tr', function() {
        console.log("Clicking on row");
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
            // emptyRoomModals();
        } else {
            orderTable.$('tr.selected').removeClass('selected');
            // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

// We use this method in order to calculate total prices in all orders which given by one customer.
function getTotalPrice(orders) {
    let totalPrice = 0;

    if (orders && orders.menuItem && Array.isArray(orders.menuItem)) {
        orders.menuItem.forEach((item) => {
            if (item && item.price && typeof item.price === 'number') {
                totalPrice += item.price;
            }
        });
    }

    return "$" + totalPrice;
}


function getOrderData() {

    console.log('inside getOrderData');
    // http:/localhost:9090/api/orders
    // json list of orders
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(orders) {

            //           console.log('Data: ' + customers );

            if (orders) {
                orderTable.clear();
                orderTable.rows.add(orders);
                orderTable.columns.adjust().draw();
            }
        },

        fail: function(error) {
            console.log('Error: ' + error);
        }

    });

}

function createOrder() {

    console.log('inside createOrder');

    //     Put customer data from page in Javascript object --- SIMILAR TO JSON
    var orderData = {
        orderId: $("#id").val(),
        date: $("#date").val(),
        time: $("#time").val(),
        tableNumber: $("#tableNumber").val(),
        quantity: $("#quantity").val(),
        itemName: $("#itemName").val()
        }




    // Transform Javascript object to json
    var ordersJson = JSON.stringify(orderData);

    console.log(ordersJson);

    $.ajax({
        url: api,
        type: "post",
        data: ordersJson, // json for request body
        contentType: "application/json; charset=utf-8", // What we send to frontend
        dataType: "json", // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(order) {

            console.log(order);

            // Clear fields in page
            $("#id").val('');
            $("#date").val('');
            $("#time").val('');
            $("#tableNumber").val('');
            $("#itemName").val('');
            $("#quantity").val('');
            $("#price").val('');

            // Refresh table data
            getOrderData();

        },

        fail: function(error) {
            console.log('Error: ' + error);
        }

    });

}

function deleteOrder() {

    if (orderTable.row($('.selected')).data() == undefined) {
        alert("Select order first");
    } else {
        var order = orderTable.row($('.selected')).data();

        console.log(api + '/' + order.orderId);

        $.ajax({
            url: api + '/' + order.orderId,
            type: "delete",
            contentType: "application/json",
            dataType: "text", // get back from frontend
            // success: function(customer, textStatus, jqXHR){
            success: function(message) {

                console.log(message);

                // Refresh table data
                getOrderData();

            },

            fail: function(error) {
                console.log('Error: ' + error);
            }

        });



    }


}