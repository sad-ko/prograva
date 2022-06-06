package ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {

	private Merge() {}

	private static <T extends Comparable<T>> void merge(List<T> array, int l, int m, int r) {
		/* Create temp arrays */
		List<T> L = new ArrayList<>(array.subList(l, m + 1));
		List<T> R = new ArrayList<>(array.subList(m + 1, r + 1));

		int n1 = L.size();
		int n2 = R.size();

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0;
		int j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L.get(i).compareTo(R.get(j)) <= 0) {
				array.set(k, L.get(i));
				i++;
			} else {
				array.set(k, R.get(j));
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array.set(k, L.get(i));
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array.set(k, R.get(j));
			j++;
			k++;
		}
	}

	public static <T extends Comparable<T>> void sort(List<T> array, int l, int r) {

		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			Merge.sort(array, l, m);
			Merge.sort(array, m + 1, r);

			// Merge the sorted halves
			Merge.merge(array, l, m, r);
		}
	}

	public static void main(String[] args) {
		Character[] array = { 'e', 'j', 'e', 'm', 'p', 'l', 'o', 'a', 'o', 'r', 'd', 'e', 'n', 'a', 'r' };
		List<Character> list = Arrays.asList(array);

		System.out.println(Arrays.toString(array));
		Merge.sort(list, 0, list.size() - 1);
		System.out.println(Arrays.toString(array));
	}

}
