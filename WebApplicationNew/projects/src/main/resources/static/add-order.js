
function calculateBalance()
{
let total =document.getElementById("totalAmount").value;
let advance =document.getElementById("advanceAmount").value;
total = Number(total);
advance = Number(advance);
let balance = total - advance;
if(balance < 0){
    balance = 0;
}
document.getElementById("balanceAmount").value =balance;
}

document
.getElementById("orderForm")
.addEventListener("submit",function(event){
event.preventDefault();

let orderData = {
customerName:document.getElementById("customerName").value,
phone:document.getElementById("phone").value,
email:document.getElementById("email").value,
gender:document.getElementById("gender").value,
category:document.getElementById("category").value,
dressType:document.getElementById("dressType").value,
orderDate:document.getElementById("orderDate").value,
deliveryDate:document.getElementById("deliveryDate").value,
totalAmount:document.getElementById("totalAmount").value,
advanceAmount:document.getElementById("advanceAmount").value,
balanceAmount:document.getElementById("balanceAmount").value,
status:document.getElementById("status").value
};

if(orderData.customerName===""){
alert("Enter Customer Name");
return;
}
if(orderData.phone.length!==10){
alert("Enter valid 10 digit phone number");
return;
}
if(orderData.category==="Select Category"){
alert("Select Category");
return;
}

fetch("http://localhost:8080/api/orders",
    {
method:"POST",
headers:{"Content-Type":"application/json"},

body:JSON.stringify(orderData)
})
.then(response=>{ 
if(!response.ok){
throw new Error("Order Save Failed");
}
return response.json();
})
.then(data=>{
alert("Order Created Successfully 🔥");
document.getElementById("orderForm").reset();
})

.catch(error=>{
console.log(error);
alert("Server Error");

});

});