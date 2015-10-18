
/**
 * There’s a word guessing game. One person think a word, and the other one
 * guess a word, both words have the same length. The person should return the
 * number of bulls and cows for the guessing. Bulls represent the number of same
 * characters in the same spots, whereas cows represent the number of characters
 * guessed right but in the wrong spots. Write a program with two input strings,
 * return the number of bulls and cows.
 * */
public class BullAndCowsGame {
	public static void bullAndCows(String word, String guess) {
		if(word==null || guess==null ||word.length()!=guess.length()){
			System.out.println("Wrong input");
			return;
		}
		int bulls = 0; //same characters in the same spots
		int cows = 0; //same characters in the wrong spots.
		
		boolean[] isValidSpotGuess = new boolean[word.length()];
		boolean[] isValidSpotWord = new boolean[word.length()];
		for(int i=0; i<word.length();i++){
			if(word.charAt(i)==guess.charAt(i)){
				bulls++;
				isValidSpotGuess[i] = true;
				isValidSpotWord[i] = true;
			}
		}
		
		for(int i=0; i<word.length();i++){
			if(!isValidSpotGuess[i]){
				for(int j=0;j<word.length();j++){
					if(!isValidSpotWord[j] && word.charAt(j)==guess.charAt(i)){
						cows++;
						isValidSpotWord[j] = true;
						break;
					}
				}
			}
		}
		System.out.println("bulls: "+bulls+", cows: "+cows);
	}


	public static void main(String[] args) {
		String str1 = "adustessa";
		String str2 = "astudaess";
		bullAndCows(str1,str2);
	}

}
