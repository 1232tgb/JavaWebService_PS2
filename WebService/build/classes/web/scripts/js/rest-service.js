let secoes;


function showDiv(value) {
    for (let i = 0; i < secoes.length; i++) {
        if (i == value)
            $(secoes[i]).show();
        else
            $(secoes[i]).hide();
    }
}

$(() => {

    secoes = $(".secao");
    console.log(secoes.length);
    for (let i = 0; i < secoes.length; i++) {
        $(secoes[i]).hide();
    }


});