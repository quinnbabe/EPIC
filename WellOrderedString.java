import java.util.ArrayList;

/**Well Ordered String
 * You know a password is well-ordered string. Well-ordered string means that
 * the order of the characters is in an alphabetical increasing order. Like
 * “abEm” is a well-ordered number. However, “abmE” is not a well-order number.
 * Given an input# that tells you also how many digits are in the password,
 * print all possible passwords.
 */
public class WellOrderedString {
	public static ArrayList<String> result = new ArrayList<String>();
	public static void generate(int n){
		if(n<1 || n>26){
			return;
		}
		generate(n, "", 0);
		for(String s:result){
			System.out.println(s);
		}
		
	}
	public static void generate(int n, String currStr, int position){
		if(n == 0){
			result.add(currStr);
			return;
		}
		for(int i = position; i < 26; i++){
			generate(n-1,currStr+(char)('a'+i),i+1);
			generate(n-1,currStr+(char)('A'+i),i+1);
		}
	}
	public static void main(String[] args) {
		generate(3);

	}

}
