import java.util.ArrayList;

/**
 * The stepping number:
 * A number is called as a stepping number 
 * if the adjacent digits are having a difference of 1. 
 * For eg. 8,343,545 are stepping numbers. 
 * While 890, 098 are not. 
 * The difference between a ‘9’ and ‘0’ should not be considered as1. 
 * Given start number(s) and an end number (e) 
 * your function should list out all the stepping numbers in the range including both
 * the numbers s & e.
 */
public class SteppingNumber {
	public static void generate(int start, int end){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=(start+"").length();i<=(end+"").length();i++){
			for(int j=1;j<10;j++) {
				dfs(start,end,result,j,i-1);
			}
		}
		System.out.println(result.toString());
	}
	
	private static void dfs(int start, int end, ArrayList<Integer> result, int cur, int length){
		if(length==0){
			if(cur>=start && cur<=end){
				result.add(cur);
			}
			return;
		}
		int lastDigit = cur%10;
		if(lastDigit == 0){
			dfs(start, end, result, cur*10+1, length-1);
		}else if(lastDigit == 9){
			dfs(start, end, result, cur*10+8, length-1);
		}else{
			dfs(start, end, result, cur*10+lastDigit-1, length-1);
			dfs(start, end, result, cur*10+lastDigit+1, length-1);
		}
	}
	public static void main(String[] args) {
		generate(13,10000);
	}
}
