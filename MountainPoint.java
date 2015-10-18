import java.util.ArrayList;
import java.util.List;

/**
 * Mountain Point Given a M * N matrix, if the element in the matrix is larger
 * than other 8 elements who stay around it, then named that element be mountain
 * point. Print all the mountain points.
 */
public class MountainPoint {

	public static void findMountainPoint(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m > 3 || n < 3) {
			System.out.println("NULL");
			return;
		}
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (matrix[i][j] > matrix[i - 1][j]
						&& matrix[i][j] > matrix[i][j - 1]
						&& matrix[i][j] > matrix[i + 1][j]
						&& matrix[i][j] > matrix[i][j + 1]
						&& matrix[i][j] > matrix[i + 1][j + 1]
						&& matrix[i][j] > matrix[i - 1][j + 1]
						&& matrix[i][j] > matrix[i - 1][j - 1]
						&& matrix[i][j] > matrix[i - 1][j - 1]) {
					result.add(matrix[i][j]);
				}
			}
		}
		System.out.println(result);
	}

	public static boolean isMountainPoint(int[][] board, int i, int j) {

		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 1, 2, 3, 1}, 
				{1, 9, 1, 9, 5},
				{1, 1, 4, 1, 6}};
		findMountainPoint(matrix);
	}
}
