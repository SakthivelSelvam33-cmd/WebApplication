let id =
localStorage.getItem("bookingId");
let customers=[];
let services=[];
window.onload=function(){
loadCustomers();
loadServices();
loadBooking();
}

function loadCustomers()
{
fetch("http://localhost:8080/api/makeup-customers")
.then(res=>res.json())
.then(data=>
{
customers=data;
let select =document.getElementById("customerId");
data.forEach(c=>
{
select.innerHTML +=`<option value="${c.customerId}">
${c.customerName}
</option>
`;

});
});
}
function loadServices()
{
fetch("http://localhost:8080/api/makeup-services")
.then(res=>res.json())
.then(data=>{
services=data;
let select =document.getElementById("serviceId");
data.forEach(s=>
{
select.innerHTML +=`<option value="${s.serviceId}">
${s.serviceName}
</option>
`;
});
});
}

function loadBooking(){
fetch("http://localhost:8080/api/makeup-bookings/"+id)
.then(res=>res.json())
.then(b=>{
bookingId.value=b.bookingId;
customerId.value=b.customerId;
serviceId.value=b.serviceId;
bookingDate.value=b.bookingDate;
bookingTime.value=b.bookingTime;
artistName.value=b.artistName;
totalAmount.value=b.totalAmount;
advanceAmount.value=b.advanceAmount;
paymentStatus.value=b.paymentStatus;
bookingStatus.value=b.bookingStatus;
});

}

document.getElementById("updateForm").addEventListener("submit",
function(e)
{
e.preventDefault();
let total =Number(totalAmount.value);
let advance =Number(advanceAmount.value || 0);
let data=
{
customerId: 
customerId.value,
serviceId:
serviceId.value,
bookingDate:
bookingDate.value,
bookingTime:
bookingTime.value,
artistName:
artistName.value,
totalAmount:total,
advanceAmount:advance,
balanceAmount:
total-advance,
paymentStatus:
paymentStatus.value,
bookingStatus:
bookingStatus.value
};

fetch("http://localhost:8080/api/makeup-bookings/"+id,
{
method:"PUT",
headers:
{
"Content-Type":"application/json"
},
body:
JSON.stringify(data)
}
)
.then(()=>
{
alert("Booking Updated Successfully 🔥");
window.location.href="view-makeup-booking.html";
});

});