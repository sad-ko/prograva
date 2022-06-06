package ejercicios.packs;

public class Articulo implements Producto {
	private String nombre;
	private double precio;

	public Articulo(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public Articulo(Articulo art) {
		this(art.nombre, art.precio);
	}

	public void precio(double precio) {
		this.precio = precio;
	}

	public double calcularImporte() {
		return precio;
	}

	@Override
	public String toString() {
		return nombre + " - $" + calcularImporte();
	}

}
