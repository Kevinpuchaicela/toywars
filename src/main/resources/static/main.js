const URL = "http://localhost:8080"

let forms = document.querySelectorAll(".forms-puppets")
let actions = []
let player = {
    email: "",
    id: "",
    name: "",
    password: "",
    puppets: []
}
let currentPuppet = null
let puppets = []

let isOpenModal = false;


/* RENDERS */
function toggleBtnModal() {
    isOpenModal = !isOpenModal
    document.getElementById("modal").style.transform =
        isOpenModal
            ? "translate(0,0)"
            : "translate(100%,0)"

}
function getCurrentStatus(id) {
    fetch(`${URL}/rest/get/CurrentStatus/${id}`)
        .then(response => response.json())
        .then(data => {
            let outputHealth = document.getElementById("life-being__status__health__value")
            let outputCoins = document.getElementById("life-being__status__coins__value")
            let outputFatigue = document.getElementById("life-being__status__fatigue__value")
            let outputHappiness = document.getElementById("life-being__status__happiness__value")
            let outputClean = document.getElementById("life-being__status__clean__value")

            outputHealth.innerHTML = `Vida: ${data.health}`;
            outputCoins.innerHTML = `Monedas: ${data.coins}`
            outputFatigue.innerHTML = `Cansancio: ${data.fatigue}`
            outputHappiness.innerHTML = `Felicidad: ${data.happiness}`
            outputClean.innerHTML = `Limpieza: ${data.clean}`

        })
}
async function getRender(id) {
    await fetch(`${URL}/rest/render/HTML/${id}`)
        .then(response => response.text())
        .then(data => {
            console.log("RENDER" + data)
            document.getElementById("render").innerHTML = `
        <div class="life-being__render">
        <img src="${data}" alt="${data}">
            </div>`
        })
}
function getActions() {
    fetch(`${URL}/rest/getActions`)
        .then(response => response.json())
        .then(data => {
            sessionStorage.setItem("actions", JSON.stringify(data))
            actions = JSON.parse(sessionStorage.getItem("actions"))
            generateButtonsActions(data)
        })
}
function generateButtonsActions(data) {
    data.forEach(action => document.getElementById("action-buttons").innerHTML += `<button class="btn-action" onclick="doAction('${action}')">${action}</button>`)
}



function renderGame() {
    document.getElementById("game").innerHTML = `
        <div class="play">
           <header class="header-life-being">
            <div class="life-being__status">
                <div class="life-being__status__item">
                    <div id="life-being__status__health__value"></div>
                    <img src="/assets/heart.svg" alt="">
                </div>
                <div class="life-being__status__item">
                    <div id="life-being__status__coins__value"></div>
                    <img src="/assets/coin.svg" alt="">
                </div>
                <div class="life-being__status__item">
                    <div id="life-being__status__fatigue__value"></div>
                    <img src="/assets/fatigue.svg" alt="">
                </div>
                <div class="life-being__status__item">
                    <div id="life-being__status__happiness__value"></div>
                    <img src="/assets/happiness.svg" alt="">
                </div>
                <div class="life-being__status__item">
                    <div id="life-being__status__clean__value"></div>
                    <img src="/assets/clean.svg" alt="">
                </div>
            </div>
            <div class="header__info">
            ${currentPuppet.name} 
       
                <div class="header-player__settings">
                    <ul class="lista-settings">
                        <span class="lista-settings__player-info"> 
                        ${player.name} 
                        <span>${player.id}</span> 
                        <span>${player.puppets.length} ${player.puppets.length > 1 ? "mascotas" : "mascota"}</span>
                        </span>
                        <li onclick="toggleBtnModal()">Crear una nueva mascota</li>
                        <li onclick="logOutPlayer()">Log Out</li>
                    </ul>
                    
                    <i class="fas fa-ellipsis-v"></i>
                </div>
            </div>
        </header>
        <div id="render">
        </div>
        <div id="action-buttons"></div>
        </div>
`
    renderListPuppets()
    generateButtonsActions(actions)
}

/*DATA PLAYER */
function getPlayer(id) {
    return fetch(`${URL}/rest/player/${id}`)
        .then(response => response.json())
        .then(data => data)
}
function setPlayer(player){
    sessionStorage.setItem("player", JSON.stringify(player))
    player = JSON.parse(sessionStorage.getItem("player"))
}
function getDataStorage() {
    player = JSON.parse(sessionStorage.getItem("player"))

    player.puppets.forEach(puppet => {
        puppets.push(puppet)
    })
}
function logOutPlayer() {
    sessionStorage.clear();
    location.href = "/"
}


/*DATA PUPPETS*/
function doAction(action) {
    fetch(`/rest/do/${action}/${currentPuppet.id}`)
}
async function getFetchPuppet(id) {
    return await fetch(`${URL}/rest/get/puppet/${id}`).then(response => response.json())
}
async function setCurrentPuppet(id) {
    console.log("click")
    let puppet = await getFetchPuppet(id);
    sessionStorage.setItem("puppet", JSON.stringify(puppet))
    location.href = "/"
}
function renderListPuppets() {
    document.getElementById("list-puppets").innerHTML = ""
    puppets.forEach(puppet => {
        document.getElementById("list-puppets").innerHTML +=
            `
            <div class="list-puppets__item" onclick="setCurrentPuppet('${puppet.id}')">
                <div>${puppet.name}</div>
                <div>
                    <img src="${puppet.views.viewHTML}" alt="">
                </div>
            </div>
            
            `
    })
}
function setPuppetStorage() {
    sessionStorage.setItem("puppets", JSON.stringify(puppets))
}


window.addEventListener("load", async () => {
    getDataStorage();
    getActions()
    setPuppetStorage();


    if (sessionStorage.getItem("puppet")) {
        currentPuppet = JSON.parse(sessionStorage.getItem("puppet"))
    }

    if (!(currentPuppet == null)) {
        renderGame()
        setInterval(async () => {
            let playerFetch = await getPlayer(player.id)
            sessionStorage.setItem("player", JSON.stringify(playerFetch))
            player = JSON.parse(sessionStorage.getItem("player"))

            getCurrentStatus(currentPuppet.id)
            await getRender(currentPuppet.id)
        }, 1000)
    } else {
        if (player.puppets.length === 0) {
            document.getElementById("game").innerHTML = `<div class="no-mascotas">
                <p> No tienes mascotas, crea una!</p>
                <button class="btn" onclick="toggleBtnModal()">Crear una mascota</button>
            </div>`
        } else {
            document.getElementById("game").innerHTML = `<h2>Escoge una mascota con la que jugar</h2>`
            renderListPuppets()
        }
    }

    forms.forEach(form => {
        form.addEventListener("submit", async (e) => {
            e.preventDefault()
            let datos = new FormData(form)
            datos.append("id", player.id)
            await fetch(form.action,
                {
                    method: form.method,
                    body: datos
                })
            let playerFetch = await getPlayer(player.id)
            setPlayer(playerFetch)
            location.href = "/";
        })
    })
})




