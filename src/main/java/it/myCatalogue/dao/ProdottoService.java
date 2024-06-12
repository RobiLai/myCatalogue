package it.myCatalogue.dao;

import java.util.List;

import it.myCatalogue.model.Prodotto;

public interface ProdottoService {
	
	public void add(Prodotto p);
	public void update(Prodotto p);
	public void delete(int id);
	public Prodotto getById(int id);
	public List<Prodotto> getAll();

}
