import java.util.ArrayList;

/**
 * The decimal and octal values of some numbers are both palindromes sometimes.
 * Find such numbers within a given range.
 */
public class OctalAndDecimalPalindrome {
	public static void findOctalAndDecimal(int start, int end){
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for(int i=start; i<=end;i++){
			String decimal = i+"";
			String oct = getOct(i);
			
			if(isPalindrome(decimal) && isPalindrome(oct)){
				result.add(i);
			}
		}
		System.out.println(result.toString());
		//find palindrome in decimal,  then check the octal
		
	}
	private static String getOct(int num){
		StringBuilder stringBuilder = new StringBuilder();
		while(num!=0){
			stringBuilder.append(num%8);
			num = num/8;
		}
		return stringBuilder.reverse().toString();
	}
	private static boolean isPalindrome(String str){
		int left = 0;
		int right = str.length()-1;
		while(left<right){
			if(str.charAt(left)!=str.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		findOctalAndDecimal(1,1000);
	}
}
