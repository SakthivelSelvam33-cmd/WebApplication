
let allMeasurements=[];
window.onload=function()
{
loadMeasurements();
}
function loadMeasurements()
{
fetch("http://localhost:8080/api/measurements")
.then(res=>res.json())
.then(data=>{
allMeasurements=data;
displayTable(data);
})
}
function displayTable(data)
{
let table=document.getElementById("measurementList");
table.innerHTML="";
data.forEach(m=>{
table.innerHTML +=`
<tr>
<td>${m.measurementId}</td>
<td>${m.orderId}</td>
<td>${m.chest}</td>
<td>${m.waist}</td>
<td>${m.shoulder}</td>
<td>${m.sleeve}</td>
<td>${m.hip}</td>
<td>
<button class="edit-btn"
onclick="openEdit(${m.measurementId})">
Edit
</button>
<button class="action-btn"
onclick="deleteMeasurement(${m.measurementId})">
Delete
</button>
</td>
</tr>
`;
});
}
function searchMeasurement()
{
let value =document.getElementById("search").value;
let result =allMeasurements.filter(m=>
m.orderId.toString().includes(value));
displayTable(result);
}
function openEdit(id)
{
let m =allMeasurements.find(x=>x.measurementId==id);
editBox.style.display="flex";
editId.value=m.measurementId;
editChest.value=m.chest;
editWaist.value=m.waist;
editShoulder.value=m.shoulder;
editSleeve.value=m.sleeve;
editHip.value=m.hip;
editNeck.value=m.neck;
editLength.value=m.length;
}
function closeEdit()
{
editBox.style.display="none";
}

function updateMeasurement()
{
let id=editId.value;
let data=
{
orderId:allMeasurements.find(x=>x.measurementId==id).orderId,
chest:editChest.value,
waist:editWaist.value,
shoulder:editShoulder.value,
sleeve:editSleeve.value,
hip:editHip.value,
neck:editNeck.value,
length:editLength.value
};
fetch("http://localhost:8080/api/measurements/"+id,
{
method:"PUT",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(data)
}
)
.then(res=>res.json())
.then(()=>{
alert("Updated Successfully");
closeEdit();
loadMeasurements();
})
}

function deleteMeasurement(id)
{
let ok =confirm("Delete this Measurement?");
if(!ok)
return;
fetch("http://localhost:8080/api/measurements/"+id,
{
method:"DELETE"
}
)
.then(()=>{
alert("Deleted Successfully");
loadMeasurements();
})
}
