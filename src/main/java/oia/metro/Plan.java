package oia.metro;

import grafos.Grafo;
import grafos.GrafoLista;
import grafos.ListaAdyacente;
import grafos.algoritmos.MSP;
import grafos.Arista;

public class Plan {

	private Grafo grafo;
	private GrafoLista costo;

	public Plan(Arista[] grafo, int islas) {
		this.grafo = new ListaAdyacente(grafo, islas);
	}

	public void planificar() {
		costo = MSP.kruskal(grafo);
	}

	@Override
	public String toString() {
		return String.valueOf((int) costo.costo());
	}

}