package monticulos;

public class App {
	public static void main(String[] args) {
		ColaDePrioridad<Integer> m = new MaxMonticulo<>();
		m.insert(1);
		m.insert(2);
		m.insert(14);
		m.insert(3);
		m.insert(27);
		m.insert(99);
		m.insert(4);

		int size = m.size();

		for (int i = 0; i < size; i++) {
			System.out.println(m);
			m.remove();
		}

		System.out.println("---------------");

		ColaDePrioridad<Integer> n = new MinMonticulo<>();
		n.insert(1);
		n.insert(2);
		n.insert(14);
		n.insert(3);
		n.insert(27);
		n.insert(99);
		n.insert(4);

		int sizen = n.size();

		for (int i = 0; i < sizen; i++) {
			System.out.println(n);
			n.remove();
		}
	}
}
