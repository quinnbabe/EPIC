import java.util.*;
/*
A random generator (like a speaker standing in a group housie game calls out a number) 
generates out any numberfrom 1 to 1000. 
There is a 10X10 matrix. 
A random generator assigns valuesto each block of this matrix(within 1 to 1000 obviously). 
Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers 
called out by the speaker, its called a 'Mingo'. 
Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.
*/

public class mingo{
	public static void main(String[] args){
		mingo();
	}

	public static void mingo(){
		Random rand = new Random();
		Random pos = new Random();
		int count = 0;
		int[][] map = new int[10][10];
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				map[i][j] = -1;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		while(count<100){
			int random = rand.nextInt(1000);
			int row = pos.nextInt(10);
			int col = pos.nextInt(10);
			if(map[row][col] != -1){
				continue;
			}
			if(map[row][col] == -1){
				map[row][col] = random;
				count++;
			}
			//check if mingo
			boolean ifMingo = true;
			for(int i=0;i<10;i++){
				if(map[row][i]==-1 || map[i][col] == -1){
					ifMingo = false;
				}
			}
			int x=row, y=col;
			boolean ifMingoD1 = true;
			while(x>=0 && y>=0 && x<10 && y<10){
				if(map[x][y] == -1){
					ifMingoD1 = false;
				}
				x++;
				y++;
			}
			x=row;
			y=col;
			boolean ifMingoD2 = true;
			while(x>=0 && y>=0 && x<10 && y<10){
				if(map[x][y] == -1){
					ifMingoD2 = false;
				}
				x--;
				y--;
			}
			if(ifMingo||ifMingoD1||ifMingoD2){
				res.add(random);
			}
		}
		System.out.println("Total :"+res.size()+" Mingos!");
		System.out.println("Mingos: ");
		System.out.println(res);
		System.out.println("Map: ");
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				System.out.print(map[i][j]+",");
			}
			System.out.println();
		}
	}
}