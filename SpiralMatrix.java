import java.util.ArrayList;
import java.util.List;
/**
 * 10. Spiral Matrix Given a NXN matrix, starting from the upper right corner of
 * the matrix start printing values in a counter-clockwise fashion. E.g.:
 * Consider N = 4 Matrix= {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p}
 * ￼￼Your function should output: dcbaeimnoplhgfjk
 */
public class SpiralMatrix {
	public static List<Character> spiralOrder(char[][] matrix) {
		List<Character> result = new ArrayList<Character>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
		while (left <= right && top <= bottom) {
			if (top == bottom) {
				for (int i = left; i <= right; i++) {
					result.add(matrix[top][i]);
				}
				break;
			}
			if (left == right) {
				for (int i = top; i <= bottom; i++) {
					result.add(matrix[i][left]);
				}
				break;
			}
			for (int i = right; i > left; i--) {
				result.add(matrix[top][i]);
			}
			for (int i = top; i < bottom; i++) {
				result.add(matrix[i][left]);
			}
			for (int i = left; i < right; i++) {
				result.add(matrix[bottom][i]);
			}
			for (int i = bottom; i > top; i--) {
				result.add(matrix[i][right]);
			}
			left++;
			right--;
			top++;
			bottom--;

		}
		return result;
	}

	public static void main(String[] args) {
		char[][] matrix = { 
				{ 'a', 'b', 'c', 'd' }, 
				{ 'e', 'f', 'g', 'h' },
				{ 'i', 'j', 'k', 'l' }, 
				{ 'm', 'n', 'o', 'p' } };
		
		System.out.println(spiralOrder(matrix).toString());

	}

}
