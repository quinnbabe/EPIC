/**
 * Verify Password: Verify if the given password is valid/invalid 1. must be
 * 5-12 characters long 2. must contain at least one number and one lowercase
 * character 3. a sequence must not be followed by the same sequence (like
 * 123123qs is invalid, 123qs123 is valid)
 * */
public class VerifyPassword {
	public static boolean isValid(String password) {
		if (password == null || password.length() < 5 || password.length() > 12) {
			System.out.println("password should be 5-12 characters long");
			return false;
		}
		boolean[] check = new boolean[2];// number & lowercase

		for (int i = 0; i < password.length(); i++) {
			if (!check[0] && password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				check[0] = true;
			}
			if (!check[1] && password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				check[1] = true;
			}
			for (int j = i + 1; j < password.length(); j++) {
				if (password.charAt(i) == password.charAt(j)) {
					if (j + j - i < password.length()) {
						int k = 1;
						while (k < j - i) {
							if (password.charAt(i + k) != password
									.charAt(j + k)) {
								break;
							}
							k++;
						}
						if (k == j - i) {
							System.out.println("Contains sequence");
							return false;
						}
					}
				}
			}
		}

		return check[0] && check[1];

	}

	public static void main(String[] args) {
		System.out.println(isValid("134564541a"));
		System.out.println(isValid("123qs1234"));

	}

}
