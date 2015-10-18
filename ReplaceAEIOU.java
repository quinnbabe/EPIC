import java.util.Arrays;

/**
 * Replace AEIOU:
 * Replace a,e,i,o,u with A,E,I,O,U. 
 * At most four eligible letters from the rear of the string are replaced. 
 * The first three eligible letters in the string are always exempted from replacement.
 */
public class ReplaceAEIOU {
	public static void replaceAEIOU(String str){
		char[] list = str.toCharArray();
		int count = 0;
		int position = 0;
		while(position < list.length){
			if(list[position]=='a' || list[position]=='e' || list[position]=='i' || list[position]=='o' || list[position]=='u'){
				count++;
			}
			if(count==3){
				break;
			}
			position++;
		}
		count = 0;
		int positionEnd = list.length-1;
		while(position < positionEnd){
			if(list[positionEnd]=='a' || list[positionEnd]=='e' || list[positionEnd]=='i' || list[positionEnd]=='o' || list[positionEnd]=='u'){
				list[positionEnd] += 'A' - 'a';
				count++;
			}
			if(count==4){
				break;
			}
			positionEnd--;
		}
		System.out.println(Arrays.toString(list));
	}
	public static void main(String[] args) {
		String test = "aooe";
		replaceAEIOU(test);

	}

}
