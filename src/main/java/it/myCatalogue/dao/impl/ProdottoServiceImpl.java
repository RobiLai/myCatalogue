package it.myCatalogue.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import it.myCatalogue.dao.ProdottoService;
import it.myCatalogue.model.Prodotto;

public class ProdottoServiceImpl implements ProdottoService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Prodotto p) {
		
		em.persist(p);
		
	}

	@Override
	@Transactional
	public void update(Prodotto p) {
		
		em.merge(p);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		em.remove(getById(id));
		
	}

	@Override
	public Prodotto getById(int id) {
		return em.find(Prodotto.class, id);		
	}

	@Override
	public List<Prodotto> getAll() {
		
		Query sql = em.createQuery("SELECT * FROM prodotto");
		
		return sql.getResultList();
		
	}

}
