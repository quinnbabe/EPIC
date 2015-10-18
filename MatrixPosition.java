import java.util.ArrayList;


/**
 * Given an NxN matrix with unique integers: Find and print positions of all
 * numbers such that it is the biggest in its row and also the smallest in its
 * column . 
 * e.g. : In 3 x 3 with elements. 
 * 1 2 3 
 * 4 5 6 
 * 7 8 9  the number is 3 and position (1,3)
 */
public class MatrixPosition {
	private static class Node{
		int i;
		int j;
		int value;
		boolean isValid;
		Node(int i, int j, int value, boolean isValid){
			this.i = i;
			this.j = j;
			this.value = value;
			this.isValid = isValid;
		}
	}
	public static void findPosition(int[][] matrix){
		// biggest in row, samllest in column
		ArrayList<Node> maxRows = new ArrayList<Node>();
		ArrayList<Node> minColumns = new ArrayList<Node>();

		ArrayList<Node> result = new ArrayList<Node>();
		for(int i=0;i<matrix.length;i++){
			Node maxRow = new Node(i,0,matrix[i][0],true);
			Node minColumn = new Node(0,i,matrix[0][i],true);
			for(int j=1;j<matrix[0].length;j++){
				if(maxRow.value==matrix[i][j]){
					maxRow.isValid = false;
				}else if(maxRow.value<matrix[i][j]){
					maxRow = new Node(i, j, matrix[i][j], true);
				}
				if(minColumn.value == matrix[j][i]){
					minColumn.isValid = false;
				}else if(minColumn.value>matrix[j][i]){
					minColumn = new Node(j, i, matrix[j][i], true);
				}
			}
			maxRows.add(maxRow);
			minColumns.add(minColumn);
		}
		
		for(int i=0;i<matrix.length;i++){
			if(maxRows.get(i).isValid){
				if(i == minColumns.get(maxRows.get(i).j).i){
					result.add(maxRows.get(i));
				}
			}
		}
		for(int i=0;i<result.size();i++){
			System.out.println((i+1)+": value="+result.get(i).value+" position ("+result.get(i).i+", "+result.get(i).j+")");
		}
		
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{10, 9, 8}, 
				{15, 5, 6},
				{20, 8, 9} 	
			};
			findPosition(matrix);
	}

}
