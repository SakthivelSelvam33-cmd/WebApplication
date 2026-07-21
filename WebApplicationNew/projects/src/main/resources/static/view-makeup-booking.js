window.onload=function(){
loadBookings();
}
function loadBookings(){
fetch("http://localhost:8080/api/makeup-bookings/details")
.then(res=>res.json())
.then(data=>{
let table =document.getElementById("bookingList");
table.innerHTML="";
data.forEach(b=>
    {
table.innerHTML +=`
<tr>
<td>${b.bookingId}</td>
<td>${b.customerName}</td>
<td>${b.serviceName}</td>
<td>${b.bookingDate}</td>
<td>${b.bookingTime}</td>
<td>${b.artistName}</td
<td>${b.totalAmount}</td>
<td>${b.paymentStatus}</td>
<td>${b.bookingStatus}</td>
<td>
<button class="edit"
onclick="editBooking(${b.bookingId})">
Edit
</button>
<button class="payment"
onclick="paymentPage(${b.bookingId})">
Payment
</button>
<button class="delete"

onclick="deleteBooking(${b.bookingId})">
Delete
</button>
</td>
</tr>
`;
});
});
}
function editBooking(id)
{
localStorage.setItem(
"bookingId",
id
);
window.location.href="update-makeup-booking.html";
}

function paymentPage(id)
{

localStorage.setItem("paymentBookingId",id);
window.location.href="add-payment.html";
}

function deleteBooking(id)
{
let confirmDelete =confirm("Delete Booking?");
if(!confirmDelete)
return;
fetch("http://localhost:8080/api/makeup-bookings/"+id,
{
method:"DELETE"
}
)
.then(()=>
{
alert("Booking Deleted Successfully");
loadBookings();
});
}