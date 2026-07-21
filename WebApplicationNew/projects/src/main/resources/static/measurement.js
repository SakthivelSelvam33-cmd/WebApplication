
document.addEventListener("DOMContentLoaded",()=>{
fetch("http://localhost:8080/api/orders")
.then(res=>res.json())
.then(data=>{
let dropdown =document.getElementById("orderId");
data.forEach(order=>{
let option =document.createElement("option");
option.value =order.orderId;+order.customerName+" - "+order.dressType;
dropdown.appendChild(option);
});
})
.catch(error=>
{
console.log(error);
});
});

document.getElementById("measurementForm").addEventListener("submit",function(e){
e.preventDefault();
let data = {
orderId:document.getElementById("orderId").value,
chest:document.getElementById("chest").value,
waist:document.getElementById("waist").value,
shoulder:document.getElementById("shoulder").value,
sleeve:document.getElementById("sleeve").value,
hip:document.getElementById("hip").value,
neck:document.getElementById("neck").value,
length:document.getElementById("length").value
};
fetch("http://localhost:8080/api/measurements",
{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(data)
})
.then(res=>{
if(!res.ok){
throw new Error(
"Measurement Save Failed"
);

}
return res.json();
})
.then(result=>{
alert("Measurement Saved Successfully 🔥");
document.getElementById("measurementForm").reset();
})
.catch(error=>
{
console.log(error);
alert("Server Error"
);
});
});