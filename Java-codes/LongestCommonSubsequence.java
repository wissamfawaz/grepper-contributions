
/*
	This is an implementation that efficiently
	finds the longest common subsequence of 
	two strings. 

	Let n be the size of first string and 
	m the size of the second string.
	Time complexity: O(nm)
	Space complexity: O(nm)
*/
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "ZXVVYZW", str2 = "XKYKZPW";
		// Below outputs: [X, Y, Z, W]
		System.out.println(longestCommonSubsequence(str1, str2));
	}

	private static List<Character> longestCommonSubsequence(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0)
			return new ArrayList<Character>();
		// Matrix storing lengths of longest subsequence
		// for different prefix combinations
		int[][] L = new int[str1.length() + 1][str2.length() + 1];

		List<Character> result = new ArrayList<>();
		for (int i = 0; i < L[0].length; i++) {
			L[0][i] = 0;
		}

		for (int i = 0; i < L.length; i++) {
			L[i][0] = 0;
		}
		// Solve the problem using dynamic programming
		for (int i = 1; i < L.length; i++) {
			for (int j = 1; j < L[i].length; j++) {
				// Distinguish between case where current
				// chars match up and case where they don't
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		// Build the sequence
		int i = L.length - 1, j = L[0].length - 1;
		while (i >= 1 && j >= 1) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				result.add(str1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (L[i - 1][j] > L[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}

		Collections.reverse(result);
		return result;

	}
}
