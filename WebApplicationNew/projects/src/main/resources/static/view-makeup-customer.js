
let customers=[];
window.onload=function(){
loadCustomers();
}
function loadCustomers()
{
fetch("http://localhost:8080/api/makeup-customers")
.then(res=>res.json())
.then(data=>{
customers=data;
displayCustomers(data);
});

}
function displayCustomers(data)
{
let table =document.getElementById("customerList");
table.innerHTML="";
data.forEach(c=>{
table.innerHTML +=`
<tr>
<td>${c.customerId}</td>
<td>${c.customerName}</td>
<td>${c.phone}</td>
<td>${c.email}</td>
<td>${c.address}</td>
<td>
<button class="edit"
onclick="openEdit(${c.customerId})">
Edit
</button>
<button class="delete"
onclick="deleteCustomer(${c.customerId})">
Delete
</button>
</td>
</tr>
`;

});
}
function searchCustomer()
{
let value =document.getElementById("search").value.toLowerCase();
let result = customers.filter(c=>
c.customerName.toLowerCase().includes(value)
);
displayCustomers(result);
}
function openEdit(id)
{
let c =customers.find(x=>x.customerId==id);
editBox.style.display="flex";
editId.value=c.customerId;
editName.value=c.customerName;
editPhone.value=c.phone;
editEmail.value=c.email;
editAddress.value=c.address;
}

function closeEdit()
{
editBox.style.display="none";
}
function updateCustomer()
{
let id =editId.value;
let data={
customerName:editName.value,
phone:editPhone.value,
email:editEmail.value,
address:editAddress.value
};

fetch("http://localhost:8080/api/makeup-customers/"+id,
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
alert("Updated Successfully");
closeEdit();
loadCustomers();
});
}
function deleteCustomer(id){
if(confirm("Delete Customer?")){
fetch("http://localhost:8080/api/makeup-customers/"+id,
{
method:"DELETE"
}
)
.then(()=>
{
alert(
"Deleted Successfully"
);
loadCustomers();
});
}
}