$(document).ready(function(){
	$('.btn-excluir').click(function(){
		var desc = $(this).attr('titulo-id');
		var resposta = confirm('Deseja realmente excluir o título ' + desc + '?');
		if (resposta){
			alert('aqui vou excluir!');
		} else {
			alert('aqui não vou excluir!');
		}
	});
});