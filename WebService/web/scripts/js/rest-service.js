let secoes;


function showDiv(value) {
    for (let i = 0; i < secoes.length; i++) {
        if (i == value)
            $(secoes[i]).show();
        else
            $(secoes[i]).hide();
    }
}

async function readAll(){
    let descricao = $("#create-descricao");
    let marca = $("#create-marca");
    let preco = $("#create-preco");

    if(descricao.val() == ""){
        alert("Insira o valor da descrição.");
        return;
    }

    if(marca.val() == ""){
        alert("Insira o valor da marca.");
        return;
    }

    if(preco.val() == ""){
        alert("Insira o valor do preco.");
        return;
    }

    const URL = `/Catalogo/Produtos`;
    const dadosProduto = {
        'descricao':descricao.val(),
        'marca':marca.val(),
        'preco':preco.val()
    };

    const postRequest = {
        method:'POST',
        body:JSON.stringify(dadosProduto),
        headers:{
            'Content-type': 'application/json;charset=UTF-8'
        }
    };
    try {
        fetch(URL, postRequest).then(resposta=>resposta.json()).then(jsonResponse =>()=>{
            $("#insert-message").html(`O professor foi inserido - id:${jsonResponse.id}`);
        })
    } catch (error) {
       console.error(error);
    }


}


$(() => {

    secoes = $(".secao");
    console.log(secoes.length);
    for (let i = 0; i < secoes.length; i++) {
        $(secoes[i]).hide();
    }


});