package monticulos;

public class App {
	public static void main(String[] args) {
		MaxMonticulo<Integer> m = new MaxMonticulo<>();
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
			m.rmMax();
		}
	}
}
