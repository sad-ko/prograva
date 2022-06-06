package ordenamiento;

import java.util.Arrays;

public class Shell {

	private Shell() {
	}

	public static <T extends Comparable<T>> void sort(T[] array, int[] h_array) {
		for (int h : h_array) {
			for (int offset = 0; offset < h; offset++) {
				for (int i = offset; i < array.length; i += h) {
					T temp = array[i];
					int j;

					for (j = i; j >= h && temp.compareTo(array[j - h]) < 0; j -= h) {
						array[j] = array[j - h];
					}

					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Character[] array = { 'e', 'j', 'e', 'm', 'p', 'l', 'o', 'a', 'o', 'r', 'd', 'e', 'n', 'a', 'r' };
		int[] h = { 1, 4, 13, 40 };

		System.out.println(Arrays.toString(array));
		Shell.sort(array, h);
		System.out.println(Arrays.toString(array));
	}
}
