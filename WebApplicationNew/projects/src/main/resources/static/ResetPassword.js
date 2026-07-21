document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("resetForm");

    form.addEventListener("submit", function (e) {

        e.preventDefault();

        let email = localStorage.getItem("resetEmail");
        let password = document.getElementById("password").value;
        let msgBox = document.getElementById("msg");

        msgBox.innerHTML = "";

       
        if (!email) {
            msgBox.innerHTML = "Email not found. Please restart forgot password flow";
            return;
        }

        if (!password) {
            msgBox.innerHTML = "Password cannot be empty";
            return;
        }

        if (password.length < 6) {
            msgBox.innerHTML = "Password minimum 6 characters";
            return;
        }

       
        let data = {
            email: email,
            password: password
        };

        console.log("Sending data:", data);

        
        fetch("http://localhost:8080/user/reset-password", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })

        .then(async res => {

            let text = await res.text();

            if (!res.ok) {
                throw new Error(text || "Request failed");
            }

            return text;
        })

        .then(result => {

            msgBox.innerHTML = result;

            if (result.toLowerCase().includes("success") ||
                result.toLowerCase().includes("updated")) {

                localStorage.removeItem("resetEmail");

                setTimeout(() => {
                    window.location.href = "login.html";
                }, 1500);
            }
        })

        .catch(error => {
            console.log("Error:", error);
            msgBox.innerHTML = error.message;
        });
    });
});