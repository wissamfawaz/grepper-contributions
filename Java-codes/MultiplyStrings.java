
/*
	This is an implementation that demonstrates
	how to efficiently multiply two int numbers
	that are represented as strings.

	Let M be the number of digits in first
	and N the number of digits in second.

	Time complexity: O(M*N) 
	Space complexity: O(M+N)
*/

public class MultiplyStrings {
	public static void main(String[] args) {
		String num1 = "123", num2 = "456";
		System.out.println(multiply(num1, num2)); // 56088
	}

	private static String multiply(String num1, String num2) {
		// If either is 0, return 0
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		// Convert the numbers into StringBuilder objects
		StringBuilder firstNum = new StringBuilder(num1);
		StringBuilder secondNum = new StringBuilder(num2);

		// Reverse both numbers before performing the multiplication
		firstNum.reverse();
		secondNum.reverse();

		// Create answer variable as placeholder for
		// multiplication of each digit of firstNum with secondNum
		int N = firstNum.length() + secondNum.length();
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; i++) {
			answer.append("0");
		}
		int digit1, digit2;
		for (int place2 = 0; place2 < secondNum.length(); place2++) {
			digit2 = secondNum.charAt(place2) - '0';
			// Multiply current digit2 by all digits in firstNum
			for (int place1 = 0; place1 < firstNum.length(); place1++) {
				digit1 = firstNum.charAt(place1) - '0';
				// Current position in answer depends on place
				// of digit2 and place of digit1
				int currentPos = place1 + place2;
				// Digit currently at position currentPos is carried over
				// and summed with current result
				int carry = answer.charAt(currentPos) - '0';
				int product = digit1 * digit2 + carry;
				// Set the ones place of product
				answer.setCharAt(currentPos, (char) (product % 10 + '0'));
				// Add the carry to next position
				int value = (answer.charAt(currentPos + 1) - '0') +
						product / 10;
				answer.setCharAt(currentPos + 1, (char) (value + '0'));
			}
		}
		// Remove excess 0 from the rear of the answer
		if (answer.charAt(answer.length() - 1) == '0') {
			answer.deleteCharAt(answer.length() - 1);
		}
		answer.reverse();
		return answer.toString();
	}

}
