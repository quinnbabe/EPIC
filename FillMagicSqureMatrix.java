
/**
 * A magic square of order n is an arrangement of the numbers from 1 to n^2 in
 * an n by n matrix with each number occurring exactly once so that each row,
 * each column and each main diagonal has the same sum. 
 * Then should be an odd number. 
 * In the middle cell of the top row, fill number 1.Then go to above row
 * and right column, and fill following number 2. If it’s out of boundary, go to
 * the opposite row or column. If the next cell is already occupied, go to the
 * cell below this cell and fill following number. 
 * An example of 5*5 grid is like this for the first 9 numbers: 
 * 0 0 1 8 0 
 * 0 5 7 0 0 
 * 4 6 0 0 0 
 * 0 0 0 0 3 
 * 0 0 0 2 9
 */
public class FillMagicSqureMatrix {
	//start from position(n/2,n)
	//next position is (x-1,y+1)
	//if occupied (x+2)(y-1)
	//if x,y==-1 then x,y=n-1
	//if x,y==n then x,y=0
	public static void fillMagicMatrix(int N){	
		if(N<=0 || N%2==0){
			System.out.println("Wrong input!");
			return;
		}
		int x = 0;
		int y = N/2;
		
		int[][] matrix = new int[N][N];
		for(int i=1;i<=N*N;i++){
			if(x==-1){
				x = N-1;
			}
			if(y==N){
				y=0;
			}
			while(matrix[x][y] != 0){
				x++;
				if(x==N){
					x = 0;
				}
				x++;
				if(x==N){
					x = 0;
				}
				y--;
				if(y==-1){
					y=N-1;
				}
			}
			matrix[x][y] = i;
			x--;
			y++;
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		fillMagicMatrix(5);
	}

}
