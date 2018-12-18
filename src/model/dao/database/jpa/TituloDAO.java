package model.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Titulo;

public class TituloDAO implements DAO {

	private final EntityManager manager;
	
	public TituloDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(Titulo t) {
		manager.persist(t);
	}

	@Override
	public Titulo read(Long id) {
		Titulo t = manager.find(Titulo.class, id);
		return t;
	}

	@Override
	public void update(Titulo t) {
		manager.merge(t);
	}

	@Override
	public void delete(Long id) {
		Titulo t = this.read(id);
		manager.remove(t);
	}
	
	@SuppressWarnings("unchecked")
	public List<Titulo> find(String pesquisa){		
		if (pesquisa == null) {
			pesquisa = "";
		}
		
		List<Titulo> entitys = manager
				.createQuery("SELECT t FROM Titulo AS t WHERE t.descricao LIKE :pesquisa")
				.setParameter("pesquisa", "%" + pesquisa + "%")
				.getResultList();
		return entitys;
	}
}
