import java.util.HashSet;

/**
 * Print all palindromes of size greater than or equal to 3 of a given string.
 * (How to do it with DP)?
 * */
public class Palindromes {
	public static void generatePalindromes(String input){
		HashSet<String> res = new HashSet<String>();
		if(input.length()<3){
			System.out.println("Wrong input");
			return;
		}
		int position = 1;
		while(position<input.length()-1){
			int left = position - 1;
			int right = position+1;
			while(left>=0 && right<input.length()){
				if(input.charAt(left)==input.charAt(right)){
					res.add(input.substring(left,right+1));
					left--;
					right++;
					continue;
				}
				break;
			}
			
			left = position;
			right = position+1;
			boolean isValid = false;
			while(left>=0 && right<input.length()){
				if(input.charAt(left)==input.charAt(right)){
					if(isValid){
						res.add(input.substring(left,right+1));
					}
					isValid = true;
					left--;
					right++;
					continue;
				}
				break;
			}
			
			position++;
		}
		
		for(String s:res){
			System.out.println(s);
		}
	} 
	public static void main(String[] args) {
		String s = "abbacollocxxhooooh";
		generatePalindromes(s);
	}

}
