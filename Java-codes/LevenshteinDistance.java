/*
	This is an implementation that solves the following
	problem: 
	Consider two strings str1 and str2, with 
	lengths of n and m respectively. What is the min
	number of single-character edit operations needed
	to convert str1 to str2?


	Let n and m be the lengths of the two considered
	string values. 
	Time complexity: O(nm) 
	Space complexity: O(nm)
*/
public class LevenshteinDistance {
	// Edit distance: aka Levenshtein distance
	// Below method find the Levenshtein distance
	private static int findMinDistance(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();
		int[][] distance = new int[len1 + 1][len2 + 1];
		// idx i reflects the number of characters in
		// subset of characters taken from str1.
		// i = 0 => empty string; i=1 => first char of str1, etc...
		// If second string is empty => only option is to
		// insert characters from first string => dist = i
		for (int i = 0; i <= len1; i++) {
			distance[i][0] = i;
		}
		// idx j reflects the number of characters in
		// subset of characters taken from str2.
		// i = 0 => empty string; i=1 => first char of str2, etc...
		// If first string is empty => only option is to
		// insert characters from second string => dist = j
		for (int j = 0; j <= len2; j++) {
			distance[0][j] = j;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				// Distance depends on whether characters at
				// i-1 and j-1 are the same. If so, cost = 0
				// otherwise, cost = 1.
				int cost = (str1.charAt(i - 1) == str2.charAt(j - 1))
						? 0
						: 1;
				// Distance is min between insert, remove, and
				// replace operations.
				distance[i][j] = Math.min(
						Math.min(
								distance[i - 1][j] + 1,
								distance[i][j - 1] + 1),
						distance[i - 1][j - 1] + cost);
			}
		}

		return distance[len1][len2];
	}

	public static void main(String[] args) {
		String str1 = "love", str2 = "movie";
		// It takes two operations to convert
		// "love" to "movie". Replace l with m and
		// then insert i into str1.
		System.out.println(findMinDistance(str1, str2)); // 2
	}
}
