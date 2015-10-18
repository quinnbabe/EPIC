import java.util.*;
/*
 * Phone has letters on the number keys. For example, 
 * number 2 has ABC on it, number 3 has DEF, 4 number has GHI,..., 
 * and number 9 has WXYZ. Write a program that will print out 
 * all of the possible combination of those letters depending 
 * on the input. 
 */
 
public class keypadPermutation{
	
	private static String[] map = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public static void main(String[] args){
		generate("23");
	}
	
	public static void generate(String digits){
		List<String> res = new ArrayList<String>();
	  generate(res, 0, digits, "");
	  for(String s:res){
	  	System.out.println(s);
	  }
	}
	
	public static void generate(List<String> res, int pos, String digits, String pre){
		if(pos == digits.length()){
			res.add(pre);
			return;
		}
		String curr = map[digits.charAt(pos)-'0'];
		for(int i=0;i<curr.length();i++){
			generate(res,pos+1,digits,pre+curr.charAt(i));
		}
	}
	
}