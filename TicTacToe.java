/**
 * N*N matrix is given with input red or black. 
 * You can move horizontally, vertically or diagonally. 
 * If 3 consecutive same colors found, that color will get 1 point. 
 * So if 4 red are vertically then point is 2. 
 * Find the winner.
 */
public class TicTacToe {
	public static void tictactoe(char[][] matrix){
		int red = calculate('r', matrix);
		int black = calculate('b', matrix);
		if(red<black){
			System.out.println("Black win!"+" red="+red+" ,black="+black);
		}else{
			System.out.println("Red win!"+" red="+red+" ,black="+black);
		}
	}
	private static int calculate(char s, char[][] matrix){
		int count = 0;
		//horizontally + vertically 
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length-2; j++){
				if(matrix[i][j]==s && matrix[i][j+1]==s && matrix[i][j+2]==s){
					count++;
				}
				if(matrix[j][i]==s && matrix[j+1][i]==s && matrix[j+2][i]==s){
					count++;
				}
			}
		}
		
		//diagonally
		for(int i=0; i<matrix.length-2; i++){
			for(int j=0; j<matrix.length-2; j++){
				if(matrix[i][j]==s && matrix[i+1][j+1]==s && matrix[i+2][j+2]==s){
					count++;
				}
				if(matrix[i][matrix.length-1-j]==s && matrix[i+1][matrix.length-2-j]==s && matrix[i+2][matrix.length-3-j]==s){
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		char[][] matrix = { 
				{ 'r', 'r', 'r', 'b' }, 
				{ 'r', 'b', 'r', 'b' },
				{ 'r', 'b', 'r', 'b' }, 
				{ 'r', 'r', 'r', 'b' } 
			};
		tictactoe(matrix);
	}	
}
