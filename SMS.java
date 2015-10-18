/*
 * You are given a telephone keymap
 * 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 
 * 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-<space>, #-char separator
 * if you type "2", you will get 'A', that is "2"-'A', 
 * "22"-'B' ,"222"-'C', "2222"-'D'
 * However, the digits can repeated many times
 * "22222"-you get 'A' again -google 1point3acres
 * You can use "#" to separate characters, for example
 * "2#22", you get "AB". However, you may also have 
 * consecutive different digits without separator:"23"-'AD'
 * If you type "*", it means space. You a given a 
 * sequence of digits, translate it into a text message
 */
 
public class SMS{
	//Be careful about the wrong input.
	private static String[] map = {"0","1","ABC2","DEF3","GHI4","JKL5","MNO6","PQRS7","TUV8","WXYZ9"," "};
	
	public static void main(String[] args){
		translate("2233444");
	}
	
	public static void translate(String digits){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<digits.length();i++){
			if(digits.charAt(i) == '#'){
				continue;
			}
			if(digits.charAt(i) == '*'){
				sb.append(" ");
			}else{
				if(digits.charAt(i) >= '0' && digits.charAt(i) <= '9'){
					String curr = map[digits.charAt(i)-'0'];
					int select = 0;
					while(i+1<digits.length() && digits.charAt(i) == digits.charAt(i+1)){
						i++;
						select++;
					}
					sb.append(curr.charAt(select%curr.length()));
				}
				else{
					System.out.println("Wrong Input!");
					System.exit(1);
				}
			}
			}
			System.out.println(sb.toString());
}
}