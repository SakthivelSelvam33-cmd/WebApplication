let orders = [];
let editId = null;
fetch("http://localhost:8080/api/orders")
.then(res => 
{
    if(!res.ok)
    {
        throw new Error("Load Failed : " + res.status);
    }
    return res.json();
})
.then(data => 
    {
    orders = data;
    displayOrders(data);
})
.catch(error => 
    {
    console.log(error);

});
function displayOrders(data){
let html = "";
data.forEach(order => {
html += `
<tr>
<td>
${order.orderId}
</td>
<td>
${order.customerName}
</td>
<td>
${order.dressType}
</td>
<td>
₹ ${order.totalAmount}
</td>
<td>
<select onchange="changeStatus(${order.orderId},this.value)">
<option ${order.status==="Pending"?"selected":""}>
Pending
</option>
<option ${order.status==="Processing"?"selected":""}>
Processing
</option>
<option ${order.status==="Completed"?"selected":""}>
Completed
</option>
<option ${order.status==="Delivered"?"selected":""}>
Delivered
</option>
</select>
</td>
<td>
<button 
class="edit"
onclick="openEdit(${order.orderId})">
Edit
</button>
<button 
class="delete"
onclick="deleteOrder(${order.orderId})">
Delete
</button>
</td>
</tr>
`;
});
document.getElementById("orderList").innerHTML = html;
}

function openEdit(id)
{
let order = orders.find(x => x.orderId == id);
editId = id;
document.getElementById("editName").value =order.customerName
document.getElementById("editDress").value =order.dressType;
document.getElementById("editAmount").value =order.totalAmount;
document.getElementById("editStatus").value =order.status;
document.getElementById("editBox").style.display="flex";
}
function closeEdit()
{
document.getElementById("editBox").style.display="none";
}
function updateOrder()
{
let data = 
{
customerName:document.getElementById("editName").value,
dressType:document.getElementById("editDress").value,
totalAmount:document.getElementById("editAmount").value,
status:document.getElementById("editStatus").value
};

fetch(`http://localhost:8080/api/orders/${editId}`,
{
method:"PUT",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(data)
}
)
.then(res=>
{
if(!res.ok)
{
throw new Error("Update Failed : "+res.status);
}
return res.json();
})
.then(data=>{
alert("Updated Successfully 🔥");
location.reload();
})
.catch(error=>{
console.log(error);
});
}
function deleteOrder(id)
{
if(confirm("Delete this order?")){
fetch(`http://localhost:8080/api/orders/${id}`,
{
method:"DELETE"
}
)
.then(res=>
{
if(!res.ok){
throw new Error("Delete Failed : "+res.status);}
return res.text();
})
.then(data=>{
alert("Deleted Successfully");
location.reload();
})
.catch(error=>{
console.log(error);
});
}
}
function changeStatus(id,status)
{
fetch(`http://localhost:8080/api/orders/${id}/status?status=${status}`,
{
method:"PUT",
headers:{
"Content-Type":"application/json"
}
}
)
.then(res=>
{
if(!res.ok){
throw new Error("Status Failed : "+res.status);
}
return res.json();
})
.then(data=>{
console.log("Status Updated");
})
.catch(error=>{
console.log(error);
});
}

function searchOrder()
{
let value =document.getElementById("search").value.toLowerCase();
let result = orders.filter(order =>order.customerName.toLowerCase().includes(value)
);
displayOrders(result);

}