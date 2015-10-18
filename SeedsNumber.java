import java.util.ArrayList;

/**
 * Find the seed of a number. 
 * Eg : 1716:
 * 143*1*4*3 = 1716 
 * so 143 is the seed of 1716. 
 * Find all possible seed for a given number.
 */
public class SeedsNumber {
	public static void findSeeds(int num){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=1;i<=num;i++){
			int sum = i;
			int cur = i;
			while(cur>0){
				sum = sum * (cur % 10);
				cur = cur/10;
			}
			if(sum==num){
				result.add(i);
			}
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		findSeeds(1520);
	}

}
