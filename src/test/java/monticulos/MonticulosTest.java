package monticulos;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MonticulosTest {

	private static ColaDePrioridad<Integer> m;
	private static ColaDePrioridad<Integer> n;

	@BeforeClass
	public static void setup() {
		m = new MaxMonticulo<>();
		n = new MinMonticulo<>();
	}

	@Test
	public void maxInsertTest() {
		m.insert(1);
		m.insert(2);
		m.insert(14);
		m.insert(3);
		m.insert(27);
		m.insert(99);
		m.insert(4);

		int b = m.get();
		assertEquals(99, b);
	}

	@Test
	public void maxRemoveTest() {
		assertEquals(99, (int) m.remove());
		assertEquals(27, (int) m.remove());
		assertEquals(14, (int) m.remove());
		assertEquals(4, (int) m.remove());
		assertEquals(3, (int) m.remove());
		assertEquals(2, (int) m.remove());
		assertEquals(1, (int) m.remove());
	}

	@Test
	public void minInsertTest() {
		n.insert(1);
		n.insert(2);
		n.insert(14);
		n.insert(3);
		n.insert(27);
		n.insert(99);
		n.insert(4);

		int b = n.get();
		assertEquals(1, b);
	}

	@Test
	public void minRemoveTest() {
		assertEquals(1, (int) n.remove());
		assertEquals(2, (int) n.remove());
		assertEquals(3, (int) n.remove());
		assertEquals(4, (int) n.remove());
		assertEquals(14, (int) n.remove());
		assertEquals(27, (int) n.remove());
		assertEquals(99, (int) n.remove());
	}

}
