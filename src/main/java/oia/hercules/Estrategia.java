package oia.hercules;

import java.util.LinkedList;
import java.util.List;

public class Estrategia {

	private int numTurnos;
	private List<Turno> turnos;
	private int hidra;
	private List<Espada> espadas;

	public Estrategia(final int hidra, List<Espada> espadas) {
		this.hidra = hidra;
		this.espadas = espadas;
		this.turnos = new LinkedList<>();
		this.numTurnos = 0;
	}

	public void hercules() { // O(n*c + n*log(n))

		// Ordenamos en base al daño de forma descendente
		espadas.sort(Espada::compareTo); // O(n*log(n))

		for (Espada espada : espadas) { // O(n)

			Turno turno = new Turno(espada.getId());
			while (espada.puedeAtacar()) { // O(c)

				if (!turnos.contains(turno)) {
					turnos.add(turno);
				} else {
					turno = turnos.get(turnos.indexOf(turno));
					turno.incrementarUsos();
				}

				numTurnos++;

				if (espada.puedeDerrotar(hidra)) {
					return;
				}

				hidra = espada.atacar(hidra);
			}

		}

		numTurnos = -1;
		turnos.clear();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append(this.numTurnos + "\n");

		// Ordenamos los turnos por el indice de la espada de forma ascendente
		turnos.sort(Turno::compareTo);
		for (Turno turno : turnos) {
			str.append(turno + "\n");
		}

		return str.toString();
	}
}
