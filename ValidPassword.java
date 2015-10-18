
/**
 * Valid Password In 1-9 keypad one key is not working. If someone enters a
 * password then not working key will not be entered. You have given expected
 * password and entered password. Check that entered password is valid or not.
 * Ex: entered 164, expected 18684 (you need to take care as when u enter18684
 * and 164 only both will be taken as 164 input)
 */
public class ValidPassword {
	public static boolean isValidPassword(String expected, String entered) {
		if(entered.length()>expected.length()){
			return false;
		}
		//find the not working key
		int position = 0;
		boolean[] keyBoard = new boolean[9];//initial false
		while (position < expected.length()
				&& position < entered.length()
				&& expected.charAt(position) == entered.charAt(position)) {
			keyBoard[Integer.parseInt(expected.charAt(position)+"")] = true;
			position++;
		}
		if(position == expected.length() && position==entered.length()){
			return true;
		}
		if(position < entered.length() && keyBoard[Integer.parseInt(expected.charAt(position)+"")]){
			return false;
		}
		char missedKey = expected.charAt(position);
		
		//check the remaining password
		int positionExpeted = position;
		while (true) {
			while (positionExpeted < expected.length()
					&& position < entered.length()
					&& expected.charAt(positionExpeted) == entered.charAt(position)) {
				position++;
				positionExpeted++;
			}
			if (positionExpeted < expected.length()
					&& expected.charAt(positionExpeted) == missedKey) {
				positionExpeted++;
			} else {
				break;
			}
		}
		if (position == entered.length()
				&& positionExpeted == expected.length()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValidPassword("1833333368423332", "18368422"));
	}

}
