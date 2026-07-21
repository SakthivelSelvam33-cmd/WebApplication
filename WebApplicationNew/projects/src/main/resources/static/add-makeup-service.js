
document
.getElementById("serviceForm")
.addEventListener(
"submit",
function(e)
{
e.preventDefault();

let data = {
serviceName:document.getElementById("serviceName").value,
description:document.getElementById("description").value,
price:document.getElementById("price").value
};
fetch("http://localhost:8080/api/makeup-services",
{
method:"POST",
headers:{"Content-Type":"application/json"
},
body:
JSON.stringify(data)
}
)
.then(res=>{
if(!res.ok){
throw new Error();
}
return res.json();
})
.then(()=>{
alert("Makeup Service Added Successfully 🔥"
);
document.getElementById("serviceForm").reset();})
.catch(error=>
{
console.log(error);
alert("Server Error"
);

});

});