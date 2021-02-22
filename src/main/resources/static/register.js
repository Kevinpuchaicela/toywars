let formRegister = document.getElementById("form-register")
let URL = "http://localhost:8080"
formRegister.addEventListener("submit", (e) => {
    e.preventDefault();
    let data = new FormData(formRegister)
    fetch(formRegister.action, {
        method: formRegister.method,
        body: data
    }).then(response => response.json())
        .then(data => {
            if (!(data === undefined)) {
                sessionStorage.setItem("player", JSON.stringify(data));
                location.reload()
            }
        }).catch((err) => {
        alert("La direccion de correo ya está en uso.")
    })

})