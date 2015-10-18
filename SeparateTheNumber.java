

/**
 * Separate the Number:
 * Print the sequences from the input given by the user separated by semicolon
 * e.g.: 4678912356012356
 * output: 4;6789;123;56;0123;56;
 * */
public class SeparateTheNumber {
	public static void separateNumber(String number){
		if(number == null || number.length()==0){
			System.out.println("WRONG INPUT");
			return;
		}
		
		int position = 1;
		StringBuilder curSequnce = new StringBuilder();
		curSequnce.append(number.charAt(0));
		while(position<number.length()){
			if( number.charAt(position) - number.charAt(position-1) == 1){
			}
			else{
				curSequnce.append(";");
			}
			curSequnce.append(number.charAt(position));
			position++;
		}
		curSequnce.append(";");
		System.out.println(curSequnce);
	}
	
	public static void main(String[] args) {
		separateNumber("444678912355555012356");
	}
}
