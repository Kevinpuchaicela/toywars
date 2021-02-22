let formLogin = document.getElementById("form-login")

formLogin.addEventListener("submit", (e) => {
    e.preventDefault();
    let data = new FormData(formLogin)
    fetch(formLogin.action, {
        method: formLogin.method,
        body: data
    }).then(response => response.json())
        .then(data => {
            console.log(data)
            if (!(data === undefined)) {
                sessionStorage.setItem("player", JSON.stringify(data));
                location.reload()
            }
        }).catch((err) => {
        alert("El correo electronico o la contraseña no coinciden con ninguna cuenta.")
    })

})