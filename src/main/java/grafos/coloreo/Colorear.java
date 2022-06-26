package grafos.coloreo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grafos.Grafo;
import monticulos.ColaDePrioridad;
import monticulos.MaxMonticulo;
import monticulos.MinMonticulo;

public class Colorear {

	private Grafo grafo;
	private Color color;
	private List<Integer>[] relaciones;
	private ColaDePrioridad<Coloreado> queue;

	private Colorear(Grafo grafo, TipoDeOrden tipo, Color color) {
		this.grafo = grafo;
		this.color = color;

		switch (tipo) {
		case WELSH_POWELL:
			this.welshPowell();
			break;

		case MATULA:
			this.matula();
			break;
			
		case SECUENCIAL:
			
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void welshPowell() {
		this.relaciones = new List[grafo.size()];
		this.queue = new MaxMonticulo<>();

		for (int i = 0; i < relaciones.length; i++) {
			relaciones[i] = grafo.getAristasDe(i);
			queue.insert(new Coloreado(relaciones[i].size(), i));
		}
	}
	
	@SuppressWarnings("unchecked")
	private void matula() {
		this.relaciones = new List[grafo.size()];
		this.queue = new MinMonticulo<>();

		for (int i = 0; i < relaciones.length; i++) {
			relaciones[i] = grafo.getAristasDe(i);
			queue.insert(new Coloreado(relaciones[i].size(), i));
		}
	}

	private Map<String, List<Integer>> colorear() {
		Map<String, List<Integer>> coloreado = new HashMap<>();
		boolean[] coloreados = new boolean[grafo.size()];

		while (!queue.isEmpty()) {
			Coloreado c = queue.remove();
			int nodo = c.getNodo();

			if (coloreados[nodo]) {
				continue;
			}

			if (!coloreado.containsKey(color.pintar())) {
				coloreado.put(color.pintar(), new ArrayList<>());
			}
			coloreado.get(color.pintar()).add(nodo);
			coloreados[nodo] = true;

			for (int i = 0; i < relaciones.length; i++) {
				if (!relaciones[nodo].contains(i) && i != nodo && !coloreados[i]) {
					coloreado.get(color.pintar()).add(i);
					coloreados[i] = true;
				}
			}

			color.nuevoColor();
		}

		return coloreado;
	}

	public static Map<String, List<Integer>> colorear(Grafo grafo, TipoDeOrden tipo, Color color) {
		return new Colorear(grafo, tipo, color).colorear();
	}
}
