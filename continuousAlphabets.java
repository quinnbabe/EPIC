import java.util.*;

/*
 * Print continuous alphabets from a sequence of arbitrary alphabets 
 * For example: 
 * Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
 * Output: abcdef; lmnop; tuvwxyz
 * Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
 * Output: abcdef; lmnop; tuvwxyz
 */
public class continuousAlphabets{
	public static void main(String[] args){
		continuous("AbcDefljdflsjflmnopflsjflasjftuvWxYz");
	}

	public static void continuous(String input){
		input = input.toLowerCase();
		input += " "; // add a blank to ensure the last answer will be catched
		List<String> res = new ArrayList<String>();
		int left = 0, right = 0, last = 0;
		for(int i=1;i<input.length();i++){ // be careful when the loop is finished, it may lose the chance to output the last answer
			if(input.charAt(i)-input.charAt(last) == 1){
				right++;
				last++;
			}else{
				if(right!=left){
					res.add(input.substring(left,right+1));
				}
				left = i;
				right = i;
				last = i;
			}
		}
		System.out.println(res);
	}
}