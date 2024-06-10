function forceStartsWithOne(input) {
    let valor = input.value.replace(/\D/g, ''); // Remove todos os caracteres que não são dígitos
    
    // Adiciona '1' ao início se não começar com '1'
    if (!/^1/.test(valor)) {
        valor = '1' + valor;
    }
    
    // Define o novo valor no input
    input.value = valor;
}