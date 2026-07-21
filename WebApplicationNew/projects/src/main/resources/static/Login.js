document.getElementById("loginForm")
.addEventListener("submit", function(e){
e.preventDefault();
let data = 
{
email:document.getElementById("email").value,
password:document.getElementById("password").value
};
fetch("http://localhost:8080/user/login", {
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(data)
})
.then(res=>
{
return res.text();
})
.then(result=>{
console.log(result);

if(result.includes("Invalid") || result.includes("User not found")){
document.getElementById("msg").style.color="red";
document.getElementById("msg").innerHTML=result;
return;
}

let user = JSON.parse(result);
document.getElementById("msg").style.color="green";
document.getElementById("msg").innerHTML="Login Successful";
localStorage.setItem("user",JSON.stringify(user));
setTimeout(()=>
{
if(user.role === "ADMIN")
    {
window.location.href =
"Dashboard.html";
}

else{
window.location.href ="customer-home.html";
}
},1000);
})
.catch(error=>{
console.log(error);
document.getElementById("msg").style.color="red";
document.getElementById("msg").innerHTML ="Server Error";
});
});