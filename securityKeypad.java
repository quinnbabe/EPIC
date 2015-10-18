/*
 * There is a security keypad at the entrance of a building. It has 9 
 * numbers 1 - 9 in a 3x3 matrix format
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * The security has decided to allow one digit error for a person but 
 * that digit should be horizontal or vertical. Example: for 5 the user 
 * is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to 
 * enter 1, 5, 7. IF the security codeto enter is 1478 and if the user 
 * enters 1178 he should be allowed. Write a function to take security 
 * code from the user and print out if he should be allowed or not.
 */

public class securityKeypad{
	public static void main(String[] args){
		check("1478","1178");
	}

	public static void check(String code, String input){
		int count = 0;
		char error = '0';
		char right = '0';
		if(code.length()!=input.length()) {System.out.println("Fail!");return;}
		for(int i=0;i<code.length();i++){
			if(code.charAt(i) != input.charAt(i)){
				count++;
				error = input.charAt(i);
				right = code.charAt(i);
			}
		}
		if(count>1) {System.out.println("Fail!");return;}
		int wrong = Character.getNumericValue(error);
		int cool = Character.getNumericValue(right);
		if(cool == wrong-1 || cool == wrong+1 ||cool==wrong-3||cool==wrong+3){
			System.out.println("Pass!");
		}else{
			System.out.println("Fail!");
		}
	}
}