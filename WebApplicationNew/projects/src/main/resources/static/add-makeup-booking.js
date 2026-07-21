let serviceList=[];




window.onload=function()
{
    loadCustomers();
    loadServices();
}

function loadCustomers()
{
fetch("http://localhost:8080/api/makeup-customers")
.then(res=>res.json())
.then(data=>
{
    let dropdown =
    document.getElementById("customerId");
    data.forEach(c=>{
    dropdown.innerHTML +=`
    <option value="${c.customerId}">
    ${c.customerName} - ${c.phone}

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
    serviceList=data;
    let dropdown =document.getElementById("serviceId");
    data.forEach(s=>{
    dropdown.innerHTML +=`
    <option value="${s.serviceId}">
    ${s.serviceName}
</option>
`;
});
});
}

document.getElementById("serviceId").addEventListener("change",
function(){
    let id=this.value;
    let service =serviceList.find(s=>s.serviceId==id
    );
    if(service){ document.getElementById("totalAmount").value=service.price;}
});

document.getElementById("bookingForm").addEventListener("submit",
function(e){e.preventDefault();
let total =Number(totalAmount.value);
let advance =Number(advanceAmount.value || 0);
let data={customerId:customerId.value,serviceId:serviceId.value,bookingDate:bookingDate.value,bookingTime:bookingTime.value,artistName:
artistName.value,
totalAmount:
total,
advanceAmount:
advance,
balanceAmount:
total-advance,
paymentStatus:
paymentStatus.value,
bookingStatus:
bookingStatus.value
};

fetch("http://localhost:8080/api/makeup-bookings",
{

method:"POST",
headers:{
"Content-Type":"application/json"
},
body:
JSON.stringify(data)
}
)
.then(res=>res.json())
.then(()=>{
alert("Makeup Booking Saved Successfully 🔥");
document.getElementById("bookingForm").reset();

})

});
