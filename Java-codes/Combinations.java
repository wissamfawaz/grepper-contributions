
/*
	This is an implementation that demonstrates
	how to generate all possible k combinations
	out of the range [1, n] 
	

	Time complexity: O(N!/((N-k)!(k-1)!)) 
	Space complexity: O(N!/((N-k)!k!))
*/
import java.util.List;
import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		int n = 4, k = 2;
		// Below prints: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
		System.out.println(combine(n, k));
	}

	private static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentCombo = new ArrayList<>();
		combinationsUtil(currentCombo, 1, result,
				n, k);
		return result;
	}

	private static void combinationsUtil(List<Integer> currentCombo, int first, List<List<Integer>> result, int n,
			int k) {
		if (currentCombo.size() == k) {
			result.add(new ArrayList<>(currentCombo));
			return;
		}

		for (int i = first; i <= n; i++) {
			currentCombo.add(i);
			combinationsUtil(currentCombo, i + 1, result, n, k);
			currentCombo.remove(currentCombo.size() - 1);
		}

	}

}
