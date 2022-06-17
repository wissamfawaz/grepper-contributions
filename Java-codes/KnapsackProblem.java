
/*
	Given an array of items. The array consists of 
	multiple sub-arrays holding two int values, 
	representing the value and the weight of an item, 
	respectively. We are also given the maximum 
	capacity of a knapsack. 
	In light of the above, this implementation demonstrates
	how to solve the famous knapsack problem, where the aim
	is to fit items in the knapsack with a view to 
	maximizing their combined value. 

	Let c be the capacity of the knapsack and
	n be the number of items.
	Time complexity: O(nc) 
	Space complexity: O(nc)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {

	public static void main(String[] args) {
		// An array of 4 items. Each subarray holds two
		// ints representing value and weight of an item.
		int[][] items = { { 1, 2 }, { 4, 3 }, { 5, 6 }, { 6, 7 } };
		// Max capacity of knapsack
		int capacity = 10;
		List<List<Integer>> result = knapsackProblem(items, capacity);
		// Selected items are: [4, 3] at idx 1 and [6, 7] at idx 3
		System.out.println(result); // [[10], [3, 1]]
	}

	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		final int ITEMS = items.length;
		// Rows represent the items
		// Columns are the different capacity values.
		int[][] values = new int[ITEMS + 1][capacity + 1];

		int weight, value;
		// Problem is solved through dynamic programming
		for (int item = 1; item <= ITEMS; item++) {
			value = items[item - 1][0];
			weight = items[item - 1][1];
			for (int c = 0; c <= capacity; c++) {
				// If current item does not fit, then value is same
				// as the one with the previous item in knapsack
				if (weight > c) {
					values[item][c] = values[item - 1][c];
				} else {
					// Either you add current item or you don't
					values[item][c] = Math.max(values[item - 1][c], values[item - 1][c - weight] + value);
				}
			}
		}

		List<Integer> totalValue = Arrays.asList(values[ITEMS][capacity]);
		int item = ITEMS, c = capacity;
		List<Integer> finalItems = new ArrayList<>();
		// Package items added to knapsack into
		// final items list
		while (item > 0 && c > 0) {
			if (values[item][c] > values[item - 1][c]) {
				c -= items[item - 1][1];
				finalItems.add(item - 1);
			}
			item--;
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(totalValue);
		result.add(finalItems);
		return result;
	}
}
