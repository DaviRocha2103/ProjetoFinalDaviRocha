const form = document.getElementById("formulario");

form.addEventListener("butt", function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome");
    const senha = document.getElementById("senha");

    if(nome.value.trim() === "" || senha.value.trim() === "" ) {
        alert("Usuario e/ou Senha não preenchidos!");
    } else {
        form.submit();
    }
});


