document.addEventListener('DOMContentLoaded', function () {
const userInput = document.getElementById('usuario');
const emailInput = document.getElementById('#email');
const senhaInput = document.getElementById('password');
const cpfInput = document.getElementById('cpf');
const celInput = document.getElementById('tel');

form.addEventListener("submit", (event) => {
    event.preventDefault();

    if(userInput.value === ""){
        alert("Por Favor, Preencha o Nome");
        return;
    }

    if(emailInput.value === "" || !isEmailValid(emailInput.value)){
        alert("Por Favor, Preencha um Email válido");
        return;
    }

    if(!isPasswordValid(senhaInput.value)){
        alert("Por favor, preencha o campo de senha.");
        return;
    }

    if(cpfInput.value === "" || !isCpf(cpfInput.value)){
        alert("Por Favor, Preencha um CPF válido");
        return;
    }

    if(celInput.value === "" || !validaTelefone(celInput.value)){
        alert("Por Favor, Preencha um número de telefone válido");
        return;
    }
});

function isEmailValid(email){
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(email);
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
});