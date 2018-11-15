package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.dao.TituloDAO;
import model.entity.Titulo;

@Resource
public class TituloController {
	
	private Result result;
	
	public TituloController(Result result) {
		this.result = result;		
	}
	
	public void incluir() {
		Titulo titulo = new Titulo();
		titulo.setId(TituloDAO.get().size() + 1);
		
		TituloDAO.add(titulo);
		System.out.println("Título incluido com sucesso!");
	}	
	
	public void listagem() {
		Integer i = TituloDAO.get().size();
		
		Titulo ultimoTitulo = TituloDAO.get().get(i-1); 
		
		System.out.println(ultimoTitulo);
		
		result.include("ultimoCodigo", ultimoTitulo.getId());
		
		//0 1 2 3 4
		//1 2 3 4 5
	}
}
