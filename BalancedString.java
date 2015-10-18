import java.util.Stack;

/**
 * Given a string that has{},[],() and characters. Check if the string is balanced. 
 * E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
 */
public class BalancedString {
	public static void balancedString(String str){
		Stack<Character> stack = new Stack<Character>();
		int position = 0;
		while(position<str.length()){
			if(str.charAt(position)=='(' || str.charAt(position)=='[' || str.charAt(position)=='{'){
				stack.push(str.charAt(position));
			}else if(str.charAt(position)==')' || str.charAt(position)==']' || str.charAt(position)=='}'){
				if(stack.isEmpty()){
					System.out.println("Unbalanced!");
					return;
				}
				char tmp = stack.pop();
				if(tmp!=(str.charAt(position)-2) && tmp!=(str.charAt(position)-1)){
					System.out.println("Unbalanced!");
					return;
				}
			}
			position++;
		}
		if(stack.isEmpty()){
			System.out.println("Balanced!");
			return;
		}
		System.out.println("Unbalanced");
	}
	public static void main(String[] args) {
		balancedString("{a[(b])}");

	}

}
