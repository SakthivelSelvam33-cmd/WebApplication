let services=[];
window.onload=function(){
loadServices();
}
function loadServices()
{
fetch("http://localhost:8080/api/makeup-services")
.then(res=>res.json())
.then(data=>{
services=data;
displayServices(data);
});
}
function displayServices(data){
let table =document.getElementById("serviceList");
table.innerHTML="";
data.forEach(s=>{
table.innerHTML +=`
<tr>
<td>${s.serviceId}</td>
<td>${s.serviceName}</td>
<td>${s.description}</td>
<td>${s.price}</td>
<td>
<button class="edit"
onclick="openEdit(${s.serviceId})">
Edit
</button>
<button class="delete"onclick="deleteService(${s.serviceId})">
Delete
</button>
</td>
</tr>
`;
});
}

function openEdit(id)
{
let s =services.find(x=>x.serviceId==id);
editBox.style.display="flex";
editId.value=s.serviceId;
editName.value=s.serviceName;
editDescription.value=s.description;
editPrice.value=s.price;
}

function closeEdit()
{

editBox.style.display="none";


}

function updateService()
{
let id = editId.value;
let data={
serviceName:editName.value,
description:editDescription.value,
price:editPrice.value
};
fetch("http://localhost:8080/api/makeup-services/"+id,
{
method:"PUT",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(data)
}
)
.then(()=>{
alert("Service Updated Successfully");
closeEdit();
loadServices();
});
}

function deleteService(id)
{
if(confirm("Delete Service?")){
fetch("http://localhost:8080/api/makeup-services/"+id,
{
method:"DELETE"
}
)
.then(()=>{
alert("Service Deleted Successfully");
loadServices();
});
}
}