package chatprivado.accessoadatos;

public interface Procesos<T> {
	public Iterable<T> getAll();
	public T getById(Long id);
	
	public boolean insert(T o);
	public void update(T o);
	public void delete(Long id);
	
}
