package ejercicios.packs;

import java.util.List;
import java.util.ArrayList;

public class Carrito {
	private List<Producto> lista;
	private double total;

	public Carrito() {
		this.lista = new ArrayList<Producto>();
	}

	public void agregarCarrito(Producto item) {
		this.lista.add(item);
	}

	public double calcularTotal() {
		this.total = 0;
		for (Producto producto : lista) {
			total += producto.calcularImporte();
		}
		return this.total;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[Carro]");

		str.append("\n" + lista.get(0).toString());
		for (int i = 1; i < lista.size(); i++) {
			str.append("\n" + lista.get(i).toString());
		}
		str.append("\n---------------\nTotal: $" + total);

		return str.toString();
	}
}
