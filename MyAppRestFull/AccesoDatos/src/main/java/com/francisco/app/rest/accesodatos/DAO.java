package com.francisco.app.rest.accesodatos;

public interface DAO<PK,T> {
	public Iterable<T> getAll();
	public T getOne(PK id);
	public T insert(T objeto);
	public T getByUsername(String username,String password);
	
}
