const URL = "http://localhost:8080"

let outputStatus = document.getElementById("life-being__status")
let output = document.getElementById("render");
let htmlActions = document.getElementById("action-buttons")
let actions = [];
let action;

window.addEventListener("load", () => {
    console.log("dom loaded")
    // setAnyData("/rest/getActions", 'htmlActions')
    setActionData()
    console.log(actions)
    generateButtonsActions() //TODO: no funciona el metodo dinamicamente, tengo que usarlo por cosola en chrome despues de crear un puppet
})

function generateButtonsActions() {
    console.log("hi")
    actions.forEach(action => htmlActions.innerHTML += `<input type="submit" value="${action}" onclick="doAction('${action}')">`)
}

function doAction(action) {
    fetch(`/rest/do/${action}`)
    fetch(`${URL}/rest/get/CurrentStatus`)
        .then(response => response.json())
        .then(data => {
            outputStatus.innerHTML = `
        <div class="life-being__status__health">
           <div id="life-being__status__health__value">${data.healthPoints}</div>
        </div>
        <div class="life-being__status__experience">
           <div id="life-being__status__experience__value">${data.experiencePoints}</div>
           <img src="/assets/coin.svg" alt="" class="experience-coin">
        </div>`
        })
}

function setActionData(){
    fetch(`${URL}/rest/getActions`)
        .then(response => response.json())
        .then(data => actions = data)
}

/*function setAnyData(urlParam, variable) {
    fetch(`${URL+urlParam}`).then(response => response.json())
        .then(data => variable = data)
}*/


fetch(`${URL}/rest/get/CurrentStatus`)
    .then(response => response.json())
    .then(data => {
        outputStatus.innerHTML = `
        <div class="life-being__status__health">
           <div id="life-being__status__health__value">${data.healthPoints}</div>
        </div>
        <div class="life-being__status__experience">
           <div id="life-being__status__experience__value">${data.experiencePoints}</div>
           <img src="/assets/coin.svg" alt="" class="experience-coin">
        </div>`
    })





