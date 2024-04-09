import java.util.*;

public class Palindrome {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < T; i++) {
			String word = sc.next();
			int k = sc.nextInt();
			if (possiblyPalindrome(word, k)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		sc.close();
	}

	public boolean possiblyPalindrome(String word, int k) {
		if (k < 0) {
			return false;
		}
		if (isPalindrome(word)) {
			return true;
		}

		for (int i = 0; i < word.length(); i++) {
			String leftSubword = word.substring(0, i);
			String rightSubword = word.substring(i + 1);
			if (possiblyPalindrome(leftSubword + rightSubword, k - 1)) {
				return true;
			}
		}

		return false;
	}

	public boolean isPalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		Palindrome runner = new Palindrome();
		runner.run();
	}
}
