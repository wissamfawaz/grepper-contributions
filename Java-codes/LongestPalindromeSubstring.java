/*
	This implementation demonstrates how to 
	find the longest palindrome substring 
	in a given bigger string. 

	
	Let n be the length of the bigger string.

	Time complexity: O(n^2) 
	Space complexity: O(1)
*/
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s)); // bab
	}

	private static String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		}

		int maxLength = Integer.MIN_VALUE;
		String longestPalindrome = "";
		int n = s.length();

		for (int index = 0; index < n; index++) {
			for (int x = 0; index - x >= 0 && index + x < n; x++) {
				if (s.charAt(index - x) == s.charAt(index + x)) {
					int len = 2 * x + 1;
					if (len > maxLength) {
						maxLength = len;
						longestPalindrome = s.substring(index - x, index + x + 1);
					}
				} else {
					break;
				}
			}
		}

		for (int index = 0; index < n - 1; index++) {
			for (int x = 1; index - x + 1 >= 0 && index + x < n; x++) {
				if (s.charAt(index - x + 1) != s.charAt(index + x)) {
					break;
				} else {
					int len = 2 * x;
					if (len > maxLength) {
						maxLength = len;
						longestPalindrome = s.substring(index - x + 1, index + x + 1);
					}
				}
			}
		}

		return longestPalindrome;
	}
}
