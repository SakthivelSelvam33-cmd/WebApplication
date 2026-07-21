
let bookingId =localStorage.getItem("paymentBookingId");
let total=0;
window.onload=function(){
loadBooking();
}
function loadBooking()
{
fetch("http://localhost:8080/api/makeup-bookings/"+bookingId)
.then(res=>res.json())
.then(b=>{
document.getElementById("bookingId").innerHTML=b.bookingId;total=b.totalAmount;
document.getElementById("totalAmount").innerHTML=b.totalAmount;
});
}
paidAmount.addEventListener("input",
function()
{
let paid =Number(this.value || 0);
document.getElementById("balanceAmount").value=total-paid;
}
);

document.getElementById("paymentForm").addEventListener("submit",
function(e)
{
e.preventDefault();
let data=
{
bookingId:bookingId,
totalAmount:total,
paidAmount:
paidAmount.value,
balanceAmount:
balanceAmount.value,
paymentMethod:
paymentMethod.value,
paymentStatus:
paymentStatus.value
};
fetch("http://localhost:8080/api/payments",
{
method:"POST",
headers:
{
"Content-Type":"application/json"
},
body:
JSON.stringify(data)
}
)
.then(()=>{alert("Payment Saved Successfully 🔥");
window.location.href="view-makeup-booking.html";
});
});