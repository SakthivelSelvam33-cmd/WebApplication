document
.getElementById("forgotForm")
.addEventListener("submit",function(e)
{
e.preventDefault();
let data = {
email:document.getElementById("email").value};
fetch("http://localhost:8080/user/forgot-password",
{
method:"POST",
headers:
{
"Content-Type":"application/json"
},
body:JSON.stringify(data)
})
.then(res=>
{
return res.text();
})
.then(result=>
{
document.getElementById("msg").innerHTML=result;
if(result.includes("OTP Sent"))
{
localStorage.setItem("resetEmail",data.email);
setTimeout(()=>
{
window.location.href="VerifyOTP.html";
},1000);
}
})
.catch(error=>{
console.log(error);
document.getElementById("msg").style.color="red";
document.getElementById("msg").innerHTML="Server Error";
});
});