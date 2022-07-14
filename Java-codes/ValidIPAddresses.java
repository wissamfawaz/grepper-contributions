
/*
	This implementation demonstrates how 
	to generate all valid IP addresses
	based on a string that is made up of 
	digits only.

	Time complexity: O(1) 
	Space complexity: O(1)
*/
import java.util.List;
import java.util.ArrayList;

public class ValidIPAddresses {
	public static void main(String[] args) {
		String s = "25525511135";
		// Below prints: [255.255.11.135, 255.255.111.35]
		System.out.println(generateIpAddresses(s));
	}

	private static List<String> generateIpAddresses(String s) {
		List<String> allPossibleIPs = new ArrayList<>();
		int length = s.length();
		for (int idx1 = 1; idx1 < Math.min(length, 4); idx1++) {
			String[] currentIPParts = new String[] { "", "", "", "" };
			currentIPParts[0] = s.substring(0, idx1);
			if (!isValid(currentIPParts[0])) {
				continue;
			}

			for (int idx2 = idx1 + 1; idx2 < idx1 + Math.min(length - idx1, 4); idx2++) {
				currentIPParts[1] = s.substring(idx1, idx2);
				if (!isValid(currentIPParts[1])) {
					continue;
				}

				for (int idx3 = idx2 + 1; idx3 < idx2 + Math.min(length - idx2, 4); idx3++) {
					currentIPParts[2] = s.substring(idx2, idx3);
					currentIPParts[3] = s.substring(idx3);
					if (isValid(currentIPParts[2]) && isValid(currentIPParts[3])) {
						allPossibleIPs.add(String.join(".", currentIPParts));
					}

				}
			}

		}

		return allPossibleIPs;
	}

	private static boolean isValid(String part) {
		if (part.length() > 3) {
			return false;
		}
		int partAsInt = Integer.parseInt(part);
		// Any part greater than 255 is not valid
		if (partAsInt > 255) {
			return false;
		}
		// Account for leading 0s
		return part.length() == Integer.toString(partAsInt).length();
	}

}
