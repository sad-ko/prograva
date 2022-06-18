package grafos.algoritmos;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafos.Grafo;

public class Searching {
	
	private Searching() {}

	public static void BFS(Grafo grafo, int root) {
		boolean[] visitado = new boolean[grafo.size()];
		Queue<Integer> queue = new LinkedList<>();

		visitado[root] = true;
		queue.add(root);

		while (!queue.isEmpty()) {
			int v = queue.poll();

			List<Integer> aristas = grafo.getAristasDe(v);
			for (Integer w : aristas) {
				if (!visitado[w]) {
					visitado[w] = true;
					queue.add(w);
				}
			}
		}
	}

	public static void DFS(Grafo grafo, int root) {
		boolean[] visitado = new boolean[grafo.size()];
		Deque<Integer> stack = new LinkedList<>();

		visitado[root] = true;
		stack.push(root);

		while (!stack.isEmpty()) {
			int v = stack.pop();

			List<Integer> aristas = grafo.getAristasDe(v);
			for (Integer w : aristas) {
				if (!visitado[w]) {
					visitado[w] = true;
					stack.add(w);
				}
			}
		}
	}
}
