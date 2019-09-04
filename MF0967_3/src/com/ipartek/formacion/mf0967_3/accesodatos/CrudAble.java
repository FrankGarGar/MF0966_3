package com.ipartek.formacion.mf0967_3.accesodatos;

public interface CrudAble<T> {
	Iterable<T> getAll();
	T getById(Long id);
	
	void insert(T o);
	void update(T o);
	void delete(Long id);
}
