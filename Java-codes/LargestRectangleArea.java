
/*
	This is an implementation that demonstrates
	how to efficiently find the area of largest 
	rectangle that can be formed from a number
	of adjacent buildings, whose heights are given
	in an array of integers.

	Let n be the number of buildings.

	Time complexity: O(n) 
	Space complexity: O(n)
*/
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class LargestRectangleArea {
	public static void main(String[] args) {
		Integer[] heights = { 1, 3, 3, 2, 4, 1, 5, 3, 2 };
		ArrayList<Integer> buildings = new ArrayList<Integer>(Arrays.asList(heights));
		System.out.println(largestRectangleUnderSkyline(buildings)); // 9
	}

	private static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
		Stack<Integer> stack = new Stack<>();
		int[] maxArea = new int[1];
		int currentBuildingIdx;
		for (currentBuildingIdx = 0; currentBuildingIdx < buildings.size();) {
			if (stack.isEmpty() || buildings.get(stack.peek()) <= buildings.get(currentBuildingIdx)) {
				stack.push(currentBuildingIdx++);
			} else {
				updateMaxArea(stack, buildings, maxArea, currentBuildingIdx);
			}
		}

		while (!stack.isEmpty()) {
			updateMaxArea(stack, buildings, maxArea, currentBuildingIdx);
		}

		return maxArea[0];
	}

	private static void updateMaxArea(Stack<Integer> stack, ArrayList<Integer> buildings, int[] maxArea,
			int currentBuildingIdx) {
		int currentArea;
		int topBuildingIdx = stack.pop();
		if (stack.isEmpty()) {
			currentArea = buildings.get(topBuildingIdx) * currentBuildingIdx;
		} else {
			currentArea = buildings.get(topBuildingIdx) * (currentBuildingIdx - 1 - stack.peek());
		}
		if (currentArea > maxArea[0]) {
			maxArea[0] = currentArea;
		}
	}

}
