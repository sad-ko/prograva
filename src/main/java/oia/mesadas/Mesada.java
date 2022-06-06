package oia.mesadas;

public class Mesada implements Comparable<Mesada> {

	private int ancho;
	private int largo;
	private boolean apilado;

	public Mesada(final int ancho, final int largo) {
		// Ancho siempre es el mayor de los dos.
		if (ancho > largo) {
			this.ancho = ancho;
			this.largo = largo;
		} else {
			this.ancho = largo;
			this.largo = ancho;
		}
		this.apilado = false;
	}

	@Override
	public String toString() {
		return ancho + " x " + largo;
	}

	public void apilarlo() {
		this.apilado = true;
	}

	public boolean estaApilado() {
		return this.apilado;
	}

	/**
	 * Verificamos si es apilable solo por largo ya que la lista ya esta ordenada
	 * por ancho.
	 */
	public boolean apilable(Mesada otra) {
		return this.largo >= otra.largo;
	}

	@Override
	/**
	 * Ordenamos solo por ancho ya que siempre va a ser el valor mayor de los dos.
	 */
	public int compareTo(Mesada otra) {
		return (otra.ancho - this.ancho);
	}
	
	public Mesada copy() {
		return new Mesada(this.ancho, this.largo);
	}
}
