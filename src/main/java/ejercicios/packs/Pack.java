package ejercicios.packs;

import java.util.ArrayList;
import java.util.List;

public abstract class Pack implements Producto {
	protected List<Articulo> lista;

	protected Pack(List<Articulo> lista) {
		this.lista = new ArrayList<Articulo>(lista);
	}

	public double calcularTotal() {
		double total = 0;
		for (Producto producto : lista) {
			total += producto.calcularImporte();
		}
		return total;
	}

	public void agregar(Articulo item) {
		lista.add(item);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[Pack]");

		str.append("\n" + lista.get(0).toString());
		for (int i = 1; i < lista.size(); i++) {
			str.append("\n" + lista.get(i).toString());
		}

		return str.toString();
	}
}
