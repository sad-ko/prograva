package ejercicios.packs;

import java.util.List;

public class PackRegalo extends Pack implements Producto {

	public PackRegalo(List<Articulo> lista) {
		super(lista);
	}

	public double calcularImporte() {
		double total = 0;
		for (int i = 0; i < lista.size() - 1; i++) {
			total += lista.get(i).calcularImporte();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[Pack Regalo]");

		str.append("\n" + lista.get(0));

		for (int i = 1; i < lista.size(); i++) {
			if (i == lista.size() - 1) {
				Articulo art = lista.get(i);
				art.precio(0);
				str.append("\n" + art);
			} else {
				str.append("\n" + lista.get(i));
			}
		}

		return str.toString();
	}
}
