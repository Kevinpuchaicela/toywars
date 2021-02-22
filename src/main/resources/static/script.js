const URL = "http://localhost:8080";

export default async ()=> {
    let response = await fetch(`${URL}/rest/getActions`)
    return response.json();
}