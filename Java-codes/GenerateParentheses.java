
/*
	This is an implementation that efficiently
	generates all combinations of well-formed 
	parentheses for n pairs of parentheses. 

	Time complexity: O(4^n/sqrt(n)), 
	upperbound of nth Catalan number
	Space complexity: O(4^n/sqrt(n))
*/
import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
	public static void main(String[] args) {
		// Below outputs: [((())), (()()), (())(), ()(()), ()()()]
		System.out.println(generateParenthesis(3));
	}

	private static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();

		createCombinations(n, n, new StringBuilder(), result);

		return result;
	}

	private static void createCombinations(int openingNeeded, int closingNeeded, StringBuilder prefix,
			List<String> result) {
		// Keep track of number of opening and closing symbols added
		// Add a new one only if sequence remains valid.
		if (openingNeeded > 0) {
			prefix.append("(");
			createCombinations(openingNeeded - 1, closingNeeded, prefix, result);
			prefix.deleteCharAt(prefix.length() - 1);
		}

		if (openingNeeded < closingNeeded) {
			prefix.append(")");
			createCombinations(openingNeeded, closingNeeded - 1,
					prefix, result);
			prefix.deleteCharAt(prefix.length() - 1);
		}

		if (closingNeeded == 0) {
			result.add(prefix.toString());
		}
	}

}
