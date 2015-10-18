/**
 * 9. Finding Words Write a program for a word search. If there is an NxN grid
 * with one letter in each cell. Let the user enter a word and the letters of
 * the word are said to be found in the grid either the letters match
 * vertically, horizontally or diagonally in the grid. If the word is found,
 * print the coordinates of the letters as output.
 */
public class FindingWords {
	
	public static boolean findWord2(String str,	char[][] board) {
		int pos=0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == str.charAt(pos)) {
					if(check(str, board, i, j)){
						System.out.println("(" + i + ", " + j + ")");
						System.out.println("Found!");
						return true;
					}
				}
			}
		}
		System.out.println("Not Found");
		return false;
	}
	private static boolean check(String str, char[][] board, int x, int y){

		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
		int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
		//go on i++, j++, i--, j--,i++&j++, i++&j--, i--&j++, i--&j--)
		
		for(int i=0; i<8;i++){
			boolean flag = true;
			int tmpX = x;
			int tmpY = y;
			for(int j=1;j<str.length();j++){
				tmpX = tmpX + dx[i];
				tmpY = tmpY + dy[i];
				if(!(tmpX>=0 && tmpX<board.length && tmpY>=0 && tmpY<board[0].length)){
					flag = false;
					break;
				}
				if(board[tmpX][tmpY]!=str.charAt(j)){
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		 char[][] board = { 
				 { 'a', 'b', 'c', 'd' }, 
				 { 'e', 'f', 'g', 'h' },
				 { 'i', 'j', 'k', 'l' }, 
				 { 'm', 'n', 'o', 'p' } };

		findWord2("ejo",board);

	}

}
