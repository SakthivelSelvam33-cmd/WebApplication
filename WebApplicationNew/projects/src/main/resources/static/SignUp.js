document
.getElementById("signupForm")
.addEventListener("submit", function(event){


event.preventDefault();



let data = {


firstName:
document.getElementById("firstName").value,


lastName:
document.getElementById("lastName").value,


email:
document.getElementById("email").value,


phone:
document.getElementById("phone").value,


password:
document.getElementById("password").value,


confirmPassword:
document.getElementById("confirmPassword").value,


city:
document.getElementById("city").value,


state:
document.getElementById("state").value,


address:
document.getElementById("address").value,


companyName:
document.getElementById("companyName").value


};



let message =
document.getElementById("message");
if(

data.firstName=="" ||
data.lastName=="" ||
data.email=="" ||
data.phone=="" ||
data.password=="" ||
data.confirmPassword==""

){


message.style.color="red";
message.innerHTML ="Please fill all required fields";
return;
}
if(data.password !== data.confirmPassword)
{
message.style.color="red";
message.innerHTML =
"Password not matching";
return;
}
let phonePattern=/^[0-9]{10}$/;
if(!phonePattern.test(data.phone)){
message.style.color="red";
message.innerHTML ="Enter valid 10 digit phone number";
return;
}
let emailPattern =/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
if(!emailPattern.test(data.email)){
message.style.color="red";
message.innerHTML ="Enter valid email";
return;
}
fetch("http://localhost:8080/user/signup", {
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(data)
})
.then(response=>{
return response.text();
})
.then(result=>{
console.log(result);
if(result.includes("exists")){
message.style.color="red";
message.innerHTML=result;
}
else{
message.style.color="green";
message.innerHTML=
"Account Created Successfully. Mail Sent!";
setTimeout(()=>{
window.location.href="login.html";
},2000);
}

})

.catch(error=>{
console.log(error);
message.style.color="red";
message.innerHTML="Server Error";
});
});