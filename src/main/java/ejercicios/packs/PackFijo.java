package ejercicios.packs;

import java.util.List;

public class PackFijo extends Pack {
	private double precio_fijo;

	public PackFijo(List<Articulo> lista, double precio_fijo) {
		super(lista);
		this.precio_fijo = precio_fijo;
	}

	public double calcularImporte() {
		return precio_fijo;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(String.format("[Pack Fijo]: %.2f", precio_fijo));

		Articulo art = new Articulo(lista.get(0));
		art.precio(0);
		str.append("\n" + art);

		for (int i = 1; i < lista.size(); i++) {
			art = new Articulo(lista.get(i));
			art.precio(0);
			str.append("\n" + art);
		}

		return str.toString();
	}
}
