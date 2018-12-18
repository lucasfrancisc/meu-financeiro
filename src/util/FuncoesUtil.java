package util;

import javax.persistence.EntityManager;

public class FuncoesUtil {

	public static void iniciaTransacao(EntityManager manager) {
		manager.getTransaction().begin();
	}
	
	public static void cancelaTransacao(EntityManager manager) {
		manager.getTransaction().rollback();
	}
	
	public static void comitaTransacao(EntityManager manager) {
		manager.getTransaction().commit();
	}
}
