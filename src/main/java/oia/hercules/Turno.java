package oia.hercules;

import java.util.Objects;

public class Turno implements Comparable<Turno> {

	private int espada;
	private int usos;

	public Turno(final int espada) {
		this.espada = espada;
		this.usos = 1;
	}

	public void incrementarUsos() {
		this.usos++;
	}

	@Override
	public String toString() {
		return espada + " " + usos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(espada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		return espada == other.espada;
	}

	@Override
	public int compareTo(Turno o) {
		return this.espada - o.espada;
	}
}
