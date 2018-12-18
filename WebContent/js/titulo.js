$(document).ready(function (){
	
	function valida(){
		var retorno = [];
		
		var descricao = $('#input-descricao').val();
		if (descricao == ''){					
			retorno.push('descricao');
		}
		
		var tipo = $('#input-tipo').val();
		if (tipo == ''){
			retorno.push('tipo');
		}
		
		return retorno;
	}	
	
	$('#button-salvar').click(function (retorno){
		var validacao = valida(); 
		if (validacao.length > 0){
			alert('Os seguintes campos estão vazios: ' + validacao);
			retorno.preventDefault();
		}
	});
});