package ejercicios.packs;

import java.util.List;

public class PackDescuento extends Pack {
	private double descuento;

	public PackDescuento(List<Articulo> lista, double descuento) {
		super(lista);
		this.descuento = descuento;
	}

	public double calcularImporte() {
		return (calcularTotal() * descuento) / 100;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(String.format("[Pack Descuento]: %.2f", descuento));

		Articulo art = lista.get(0);
		art.precio((art.calcularImporte() * descuento) / 100);
		str.append("\n" + art);

		for (int i = 1; i < lista.size(); i++) {
			art = lista.get(i);
			art.precio((art.calcularImporte() * descuento) / 100);
			str.append("\n" + art);
		}

		return str.toString();
	}
}
