import java.util.*;
/*
 * You are given a grid of numbers. A snake sequence is made up of
 * adjacent numbers such that for each number, the number on the right
 * or the number below it is +1 or -1 its value. For example,
 *  1 3 2 6 8
 * -9 7 1 -1 2
 *  1 5 0 1 9
 *  In this grid, (3, 2, 1, 0, 1) is a snake sequence.
 *  Given a grid, find the longest snake sequences and their lengths
 *  (so there can be multiple snake sequences with the maximum length).
 *
 */

public class snakeSequence{

    public static void main(String[] args){
        int[][] matrix1 = {
                {1, 3, 2, 6, 8},
                {-9, 7, 1, -1, 2},
                {1, 5, 0, 1, 9}
        };
        int[][] matrix2 = {
                {1, 1, 2, 3, 1},
                {1, 1, 3, 4, 5},
                {1, 1, 4, 1, 6}
        };
        find(matrix1);
        find(matrix2);
    }

    public static void find(int[][] board){
        //direction does not matter here
        int m = board.length, n = board[0].length;
        int[][] map = new int[m][n];
        int max = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 1;
            }
        }
        int x =0, y=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && Math.abs(board[i][j]-board[i-1][j])==1){
                    map[i][j] = Math.max(map[i][j],map[i-1][j]+1);
                }
                if(j>0 && Math.abs(board[i][j-1]-board[i][j])==1){
                    map[i][j] = Math.max(map[i][j],map[i][j-1]+1);
                }
                if(map[i][j] > max){
                    x = i;
                    y = j;
                }
                max = Math.max(max,map[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        sb.append(board[x][y]);
        trace(res, board, x, y, max-1, sb);
        Set<String> set = new HashSet<String>();
        for(String con:res){
            set.add(con);
        }
        System.out.println(set);
        System.out.println(max);
    }

    public static void trace(List<String> res, int[][] board, int x, int y, int len, StringBuilder sb){

        //sb.append(board[x][y]);
        if(len==0){
            res.add(sb.toString());
            return;
        }
        
        int curr = board[x][y];
        board[x][y] = 'Z';
        if(y>=1 && Math.abs(board[x][y-1]-curr) == 1){
            sb.append(board[x][y-1]);
            trace(res, board, x, y-1, len-1, new StringBuilder(sb)); // should always pass a new object
            sb.deleteCharAt(sb.length()-1);
        }
        if(y<board[0].length-1 && Math.abs(board[x][y+1]-curr) == 1){
            sb.append(board[x][y+1]);
            trace(res, board, x, y+1, len-1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }
        if(x>=1 && Math.abs(board[x-1][y]-curr) == 1){
            sb.append(board[x-1][y]);
            trace(res, board, x-1, y, len-1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }
        if(x<board.length-1 && Math.abs(board[x+1][y]-curr) == 1){
            sb.append(board[x+1][y]);
            trace(res, board, x+1, y, len-1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }
        board[x][y] = curr;
    }
}