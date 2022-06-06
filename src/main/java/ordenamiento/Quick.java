package ordenamiento;

import java.util.Arrays;

public class Quick {

	private Quick() {}

	private static <T> void swap(T[] array, int i, int j) {
		T swapTemp = array[i];
		array[i] = array[j];
		array[j] = swapTemp;
	}

	private static <T extends Comparable<T>> int partition(T[] array, int begin, int end) {
		int i = (begin - 1);
		T pivot = array[end];

		for (int j = begin; j < end; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;

				Quick.swap(array, i, j);
			}
		}

		Quick.swap(array, i + 1, end);

		return i + 1;
	}

	private static <T extends Comparable<T>> void _sort(T[] array, int begin, int end) {
		if (begin < end) {
			int partitionIndex = Quick.partition(array, begin, end);

			Quick._sort(array, begin, partitionIndex - 1);
			Quick._sort(array, partitionIndex + 1, end);
		}
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		Quick._sort(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		Character[] array = { 'e', 'j', 'e', 'm', 'p', 'l', 'o', 'a', 'o', 'r', 'd', 'e', 'n', 'a', 'r' };

		System.out.println(Arrays.toString(array));
		Quick.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
