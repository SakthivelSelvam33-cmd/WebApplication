
const form = document.getElementById("contactForm");


form.addEventListener("submit",
function(){
let name =document.getElementById("name").value;
let email =document.getElementById("email").value;
if(name.length < 3){
alert("Enter valid name");
event.preventDefault();
}
else if(!email.includes("@"))
{
alert("Enter valid email");
event.preventDefault();
}
else
{
alert("Thank you "+name+" . Your message sent successfully!");
}
});
