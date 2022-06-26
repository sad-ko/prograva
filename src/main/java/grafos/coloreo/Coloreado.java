package grafos.coloreo;

import java.util.Objects;

public class Coloreado implements Comparable<Coloreado> {

	private int grado;
	private int nodo;

	public Coloreado(int grado, int nodo) {
		this.grado = grado;
		this.nodo = nodo;
	}

	public int getNodo() {
		return nodo;
	}

	@Override
	public int compareTo(Coloreado o) {
		return grado - o.grado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grado, nodo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coloreado other = (Coloreado) obj;
		return grado == other.grado && nodo == other.nodo;
	}

}
