import java.util.*;
/*
 * There is one kind of numbers call FibbonaciNumber, which satisfy 
 * the following situation:
 * A. can be split into several numbers;
 * B. The first two number are the same, the next number is equal to 
 * the sum of previous two
 * eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
 * If you are given a range by the user, find all numbers that are 
 * Fibonacci numbers.
 */

public class fibonacciNumber{
	public static void main(String[] args){
		find(1,12122437);
	}

	public static void find(int left, int right){
		List<Integer> res = new ArrayList<Integer>();
		int[] map = new int[3];
		for(int i=1;i<=9;i++){
		map[0] = i;
		map[1] = i; 
		map[2] = 2*i;
		String sum = ""+map[0]+map[1]+map[2];
		int sumI = Integer.valueOf(sum);
		while(sumI<= right){
			if(sumI>=left){
				res.add(sumI);
			}
			map[0] = map[1];
			map[1] = map[2];
			map[2] = map[0]+map[1];
			sum = sum+map[2];
			sumI = Integer.valueOf(sum);
		}
		}
		System.out.println(res);
	}
}