
/**
 * There’s a N*N board, two players join the jump game. The chess could go
 * vertically and horizontally. If the adjacent chess is opponent player’s and
 * the spot beside that is empty, then the chess could jump to that spot. One
 * chess could not been jumped twice. Given the position of the spot on the
 * board, write the program to count the longest length that chess could go.
 */

public class JumpChess {
	//0: up
	//1: down
	//2: left
	//3: right
	
	public static int jump(int[][] board, int x, int y, int come, int en) {
		int N = board.length;
		int[] count = {0,0,0,0};
		
		if(come!=1 && y<N-2 && en==board[x][y+1] && board[x][y+2]==0){
			board[x][y+2] = 5;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			count[0] = count[0] + 1 + jump(board, x, y+2, 0, en);
			board[x][y+2] = 0;
		}
		
		if(come!=0 && y>=2 && en==board[x][y-1] && board[x][y-2]==0){
			board[x][y-2] = 5;//board[x][y]
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			count[1] = count[1] + 1 + jump(board, x, y-2, 1, en);
		
			board[x][y-2] = 0;
		}
		
		if(come!=2 && x<N-2 && en==board[x+1][y] && board[x+2][y]==0){
			board[x+2][y] = 5;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			count[2] = count[2] + 1 + jump(board, x+2, y, 3, en);
			board[x+2][y] = 0;
		}
		
		if(come!=3 && x>=2 && en==board[x-1][y] && board[x-2][y]==0){
			board[x-2][y] = 5;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			count[3] = count[3] + 1 + jump(board, x-2, y, 2, en);
			board[x-2][y] = 0;
		}
		return Math.max(Math.max(Math.max(count[0], count[1]),count[2]),count[3]);
	}
	
	public static void main(String[] args) {

		int[][] board1 = {
				{0, 1, 2, 0, 2, 0},
				{0, 2, 0, 2, 0, 2},
				{0, 0, 0, 0, 2, 0},
				{0, 2, 0, 2, 0, 2},
				{0, 0, 2, 0, 2, 0},
				{0, 0, 0, 2, 0, 2}};

		System.out.println(jump(board1, 0, 1, -1, 2));
	}
}
