/*
	This implementation produces a non-attacking placement
	of chess queens. A non-attacking placement is one where
	no queen can attack another queen in a single turn.
	This is one of the best examples of backtracking. 

	Let N be the number of queens to be placed on 
	a N*N board. 
	Time complexity: O(N!)
	Space complexity: O(N^2)
*/
public class NQueensProblem {
	int[][] board;
	int N; // Number of queens

	public NQueensProblem(int N) {
		this.N = N;
		board = new int[N][N];
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * A utility function to check if a queen can be
	 * placed on board[row][col].
	 * Note that this function is called when "col" queens
	 * are already placed in columns from 0 to col -1.
	 * So we need to check only left side for attacking
	 * queens.
	 */
	public boolean isSafe(int row, int col) {
		int i, j;
		// Check the row on left side
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// Check lower diagonal on left side
		for (i = row, j = col; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public boolean solveUtil(int col) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= N) {
			return true;
		}

		/*
		 * Consider this column and try placing this queen
		 * in all rows one by one
		 */
		for (int row = 0; row < N; row++) {
			/*
			 * Check if the queen can be placed on board[row][col]
			 */
			if (isSafe(row, col)) {
				board[row][col] = 1;

				// Recur to place the rest of the queens
				if (solveUtil(col + 1) == true) {
					return true;
				}

				/*
				 * If placing queen in board[row][col] doesn't lead to a * solution then remove
				 * queen from board[i=row][col]
				 */
				board[row][col] = 0; // backtrack
			}
		}

		/*
		 * If the queen can not be placed in any row in this column col, * then return
		 * false
		 */
		return false;
	}

	/*
	 * This function solves the N Queen problem using Backtracking.
	 * It mainly uses solveNQUtil () to solve the problem.
	 * It returns false if queens cannot be
	 * placed, otherwise, return true and prints placement
	 * of queens in the form of
	 * 1s.
	 * Please note that there may be more than one solutions, this
	 * function prints one of the feasible solutions.
	 */

	public void solve() {
		if (solveUtil(0) == false) {
			System.out.println("No solution found.");
			return;
		}
		System.out.println("The following solution was found: ");
		printBoard();
	}

	public static void main(String[] args) {
		NQueensProblem problem = new NQueensProblem(4);
		problem.solve();
	}
}
