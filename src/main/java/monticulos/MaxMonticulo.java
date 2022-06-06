package monticulos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMonticulo<T extends Comparable<T>> {

	private List<T> heap;

	public MaxMonticulo() {
		heap = new ArrayList<>();
		heap.add(null);
	}

	private boolean isBigger(int i, int j) {
		return heap.get(i).compareTo(heap.get(j)) > 0;
	}

	private void sortUp() {
		for (int i = heap.size() - 1; i > 1 && isBigger(i, i / 2); i = i / 2) {
			Collections.swap(heap, i, (i / 2));
		}
	}

	private void sortDown() {
		int size = heap.size() - 1;
		if (size <= 1) {
			return;
		}

		heap.add(1, heap.remove(size));
		int i = 1;

		while (i < size) {
			T parent = heap.get(i);
			T childLeft = parent;
			T childRight = parent;

			if ((i * 2) <= size) {
				childLeft = heap.get(i * 2);
			}

			if ((i * 2) + 1 <= size) {
				childRight = heap.get((i * 2) + 1);
			}

			if (childLeft.compareTo(childRight) > 0 && childLeft.compareTo(parent) > 0) {
				Collections.swap(heap, i, i * 2);
				i = (i * 2);
			} else if (childLeft.compareTo(childRight) < 0 && childRight.compareTo(parent) > 0) {
				Collections.swap(heap, i, (i * 2) + 1);
				i = (i * 2) + 1;
			} else break;
		}
	}

	public T getMax() {
		if (heap.size() < 2) {
			return null;
		}

		return heap.get(1);
	}

	public T rmMax() {
		if (heap.size() < 2) {
			return null;
		}

		T element = heap.remove(1);
		this.sortDown();

		return element;
	}

	public void insert(T element) {
		heap.add(element);
		this.sortUp();
	}
	
	public int size() {
		return this.heap.size();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("[");
		for (int i = 1; i < heap.size(); i++) {
			str.append(heap.get(i).toString());
			if (i < heap.size() - 1) {
				str.append(", ");
			}
		}
		str.append("]");

		return str.toString();
	}
}
