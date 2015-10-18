/*
 * From a given string, replace all instances of 'a' with 
 * 'one' and 'A' with 'ONE'.
 * Example Input: " A boy is playing in a garden"
 * Example Output: " ONE boy is playing in one garden"
 * -- Not that 'A' and 'a' are to be replaced only when they
 * are single characters, not as part of another word.
 */

public class replaceString{
	public static void main(String[] args){
		String test = "A boy is playing in a garden";
		replace(test);
	}

	public static void replace(String s){
		String[] list = s.split(" ");
		for(int i=0;i<list.length;i++){
			if(list[i].equals("a")){
				list[i] = "one";
			}
			if(list[i].equals("A")){
				list[i] = "ONE";
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.length-1;i++){
			sb.append(list[i]+" ");
		}
		sb.append(list[list.length-1]);
		System.out.println(sb.toString());
	}
}