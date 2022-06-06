package oia.hercules;

public class Espada implements Comparable<Espada> {

	private int id;
	private int usos;
	private int daño;
	private int hidraRegen;

	public Espada(final int id, final int usos, final int daño, final int hidraRegen) {
		this.id = id;
		this.usos = usos;
		this.daño = daño;
		this.hidraRegen = hidraRegen;
	}

	public int atacar(int hidra) {
		this.usos--;
		return (hidra - this.daño) + this.hidraRegen;
	}

	public boolean puedeAtacar() {
		return (this.usos > 0);
	}

	public boolean puedeDerrotar(int hidra) {
		return (hidra - this.daño <= 0);
	}

	public int getId() {
		return id;
	}

	private int calcularDaño() {
		return (this.daño - this.hidraRegen);
	}

	@Override
	public int compareTo(Espada o) {
		return o.calcularDaño() - this.calcularDaño();
	}
}
