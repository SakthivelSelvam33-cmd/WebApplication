
document
.getElementById("customerForm")
.addEventListener(
"submit",
function(e)
{
e.preventDefault();

let data={
customerName:document.getElementById("customerName").value,
phone:document.getElementById("phone").value,
email:document.getElementById("email").value,
address:document.getElementById("address").value
};
fetch("http://localhost:8080/api/makeup-customers",
{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(data)
}
)
.then(res=>
{
if(!res.ok)
{
throw new Error();
}
return res.json();
})
.then(result=>{
alert("Customer Added Successfully 🔥");
document.getElementById("customerForm").reset();
})
.catch(error=>{
alert("Server Error");
console.log(error);});
});