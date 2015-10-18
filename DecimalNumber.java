/**
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999.
 * Only four decimal places are allowed. The output should be an irreducible fraction. 
 * E.g.: 
 * If the user enters 0.35,the irreducible fraction will be 7/20.
 */

public class DecimalNumber {
	
	public static void decimalNumber(String str) {
		if(str.length()>6){
			System.out.println("Wrong Input");
		}
		int number = (int)(Double.parseDouble(str)*10000);
		int gcd = GCD((int)number, 10000);
		
		System.out.println((int)number/gcd+"/"+(10000/gcd));
	}
	private static int GCD(int a, int b){
		if(a<b){
			return GCD(b, a);
		}
		a = a%b;
		if(a==0){
			return b;
		}
		return GCD(b, a);
	}
	public static void main(String[] args) {
		decimalNumber("0.55");
	}
}
