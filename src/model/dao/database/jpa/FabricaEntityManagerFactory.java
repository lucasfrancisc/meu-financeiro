package model.dao.database.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManagerFactory{

	private static FabricaEntityManagerFactory unicaInstancia;
	
	private EntityManagerFactory fabrica;
	
	private FabricaEntityManagerFactory() {
		this.fabrica = Persistence.createEntityManagerFactory("database-jpa");		
	}	
	
	public static FabricaEntityManagerFactory getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new FabricaEntityManagerFactory();
		}
		
		return unicaInstancia;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return getUnicaInstancia().fabrica;
	}
}
