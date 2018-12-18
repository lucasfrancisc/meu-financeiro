package model.dao.database.jpa;

import model.entity.Titulo;

public interface DAO {

	void create(Titulo t);
	
	Titulo read(Long id);
	
	void update(Titulo t);
	
	void delete(Long id);
}
