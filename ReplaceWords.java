 
/**
 * Given a string. 
 * Replace the words whose length>=4 and is even, 
 * with a space between the two equal halves of the word. 
 * Consider only alphabets for finding the evenness of the word
 * I/P "A person can't walk in this street"
 * O/P "A per son ca n't wa lk in th is str eet"
 */
public class ReplaceWords {
	public static void replaceWord(String str){
		String[] list = str.split(" ");
		StringBuilder result = new StringBuilder();
		for(int i=0; i<list.length; i++){
			result.append(handle(list[i])+" ");
		}
		System.out.println(result.toString());
	}
	private static String handle(String str){
		if(str.length()<4){
			return str;
		}
		int count = 0;
		for(int i=0;i<str.length();i++){
			if(('a'<=str.charAt(i) && str.charAt(i)<='z') || ('A'<=str.charAt(i) && str.charAt(i)<='Z')){
				count++;
			}
		}
		if(count>=4 && count%2==0){
			StringBuilder result = new StringBuilder();
			int tmp = 0;
			
			for(int i=0;i<str.length();i++){
				result.append(str.charAt(i));
				if(('a'<=str.charAt(i) && str.charAt(i)<='z') || ('A'<=str.charAt(i) && str.charAt(i)<='Z')){
					tmp++;
				}
				if(tmp == count/2){
					result.append(" ");
				}
			}
			return result.toString();
		}
		return str;
	}
	public static void main(String[] args) {
		String test = "A person. can't walk in this street, the,";
		replaceWord(test);
	}

}
