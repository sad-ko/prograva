package monticulos;

public interface ColaDePrioridad<T extends Comparable<T>> {

	public void insert(T element);

	public T get();

	public T remove();

	public int size();

}