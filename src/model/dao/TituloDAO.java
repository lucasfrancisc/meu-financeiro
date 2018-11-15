package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.Titulo;

public class TituloDAO {

	private static List<Titulo> titulos;
	
	public static void add(Titulo titulo) {
		if (titulos == null) {
			titulos = new ArrayList<Titulo>();
		}
		
		titulos.add(titulo);
	}
	
	public static List<Titulo> get(){
		if (titulos == null) {
			titulos = new ArrayList<Titulo>();
		}
		
		return titulos;
	}
}