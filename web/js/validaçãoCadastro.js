const userInput = document.querySelector("#usuario")
const emailInput = document.querySelector("#email")
const senhaInput = document.querySelector("#password")
const cpfInput = document.querySelector("#cpf")
const celInput = document.querySelector("#tel")
const submitBtn = document.getElementById("confBtn");


form.addEventListener("submit", (event) => {
    event.preventDefault();

    

    if(user.value === ""){
        alert("Por Favor, Preencha o Nome");
        return;
    }

    
    if(email.value ==="" || !isEmailValid(email.value)){
        alert("Por Favor, Preencha o Email");
        return;
    }

    

     if (!isPasswordValid(password.value)) {
        alert("Por favor, preencha o campo de senha.");
        return;
    }

    if(cpf.value === "" || !isCpf(cpf.value)){
        alert("Por Favor, Preencha o CPF ");
        return;
    }

    
    if(tel.value === "" || !validaTelefone(tel.value)){
        alert("Por Favor, Preencha o campo do número de telefone");
        return;
    }
    
});




function isEmailValid(email){

    const emailRegex = new RegExp(
        /^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,}$/
    );

    if(emailRegex.test(email)){
        return true;
    }

    return false;
}

function isPasswordValid(password) {
    return password.trim() !== "";
}

function isCpf(cpf){
    
    cpf = cpf.replace(/\D/g, ''); 
    if (cpf.length !== 11 || /^(.)\1{10}$/.test(cpf)) return false; 
    let soma = 0;
    for (let i = 0; i < 9; i++) {
        soma += parseInt(cpf.charAt(i)) * (10 - i);
    }
    let remainder = 11 - (soma % 11);
    if (remainder === 10 || remainder === 11) remainder = 0;
    if (remainder !== parseInt(cpf.charAt(9))) return false; 
    soma = 0;
    for (let i = 0; i < 10; i++) {
        soma += parseInt(cpf.charAt(i)) * (11 - i);
    }
    remainder = 11 - (soma % 11);
    if (remainder === 10 || remainder === 11) remainder = 0;
    if (remainder !== parseInt(cpf.charAt(10))) return false; 
    return true; 
}


function validaTelefone(tel) {
    const telefoneRegex = /^\d{10,11}$/; 
    return telefoneRegex.test(tel);
}

