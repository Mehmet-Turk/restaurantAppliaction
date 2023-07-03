function displayReservationDetails() {
    var reservation = JSON.parse(localStorage.getItem('reservation'));
    const reservationContainer = document.getElementById('reservationDetails');
    const reservationInfo = document.createElement('div');
        reservationInfo.innerHTML = `
            <p><strong>Reservation Number:</strong> ${reservation.reservationId}</p>
            <p><strong>Full Name:</strong> ${reservation.fullName}</p>
            <p><strong>Date:</strong> ${reservation.date} </p>
            <p><strong>Time:</strong> ${reservation.time}</p>
            <p><strong>Number of People:</strong> ${reservation.numberOfPeople}</p>
            <p><strong>Phone Number:</strong> ${reservation.phoneNumber}</p>
            <p><strong>Email:</strong> ${reservation.email}</p>
            <p><strong>Room Number:</strong> ${reservation.roomNumber}</p>
            <p><strong>Baby Chair:</strong> ${reservation.addBabyChair ? 'Yes' : 'No'}</p>
        `;

        const tableInfo = document.createElement('div');
        tableInfo.innerHTML = '<h3>Table Number</h3>';
reservation.table.forEach((table, index) => {
    const tableElement = document.createElement('span');
    tableElement.innerHTML = table.tableNumber;
    if (index !== reservation.table.length - 1) {
        tableElement.innerHTML += ', ';
    }
    tableInfo.appendChild(tableElement);
});


        reservationContainer.appendChild(reservationInfo);
        reservationContainer.appendChild(tableInfo);
        localStorage.removeItem('reservation');
    }