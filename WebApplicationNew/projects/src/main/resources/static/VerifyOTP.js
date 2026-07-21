// Set email from localStorage (forgot password step)
document.addEventListener("DOMContentLoaded", function () 
{
    const savedEmail = localStorage.getItem("resetEmail");
    if (savedEmail) 
    {
        document.getElementById("email").value = savedEmail;
    }

});
document.getElementById("otpForm").addEventListener("submit", function (e) 
{
    e.preventDefault();
    let email = document.getElementById("email").value;
    let otp = document.getElementById("otp").value;
    let data = 
    { email: email,
        otp: otp
    };
    fetch("http://localhost:8080/user/verify-otp", 
    {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(res => res.text())
    .then(result => {
        document.getElementById("msg").innerHTML = result;
        if (result.toLowerCase().includes("verified")) 
            {
            localStorage.setItem("resetEmail", email);
            setTimeout(() => {
                window.location.href = "ResetPassword.html";
            }, 1000);

        }

    })
    .catch(error => 
        {
        console.log("Error:", error);
        document.getElementById("msg").innerHTML = "Server error. Try again.";

    });
});