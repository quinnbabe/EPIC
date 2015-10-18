import java.util.ArrayList;

/**
 * Count And Say First, let user input a number, say 1. Then, the function will
 * generate the next 10numbers which satisfy this condition: 1,
 * 11,21,1211,111221,312211... explanation: first number 1, second number is one
 * 1, so 11. Third number is two1(previous number), so 21. next number one 2 one
 * 1, so 1211 and so on...
 */
public class CountAndSay {

	public static ArrayList<String> countAndSay(int n) {
		ArrayList<String> result = new ArrayList<String>();
		String currStr = n + "";
		result.add(currStr);
		int num = 10;
		while (num > 1) {
			StringBuilder sBuilder = new StringBuilder();
			currStr = result.get(result.size() - 1);
			if (currStr.length() == 1) {
				sBuilder.append(1);
				sBuilder.append(currStr);
				currStr = sBuilder.toString();
			} else {
				int position = 1;
				int count = 1;
				char curr = currStr.charAt(0);
				while (position < currStr.length()) {
					if (currStr.charAt(position) == curr) {
						count++;
					} else {
						sBuilder.append(count);
						sBuilder.append(curr);
						curr = currStr.charAt(position);
						count = 1;
					}
					position++;
				}
				sBuilder.append(count);
				sBuilder.append(curr);
			}
			num--;
			result.add(sBuilder.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<String> rArrayList = countAndSay(3);
		int i = 0;
		for (String r : rArrayList) {
			System.out.println(i + ": " + r);
			i++;
		}

	}

}
