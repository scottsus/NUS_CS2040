import java.util.*;

public class Football {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] players = new int[N];
		for (int i = 0; i < N; i++) {
			players[i] = sc.nextInt();
		}
		sc.close();

		boolean[] seen = new boolean[N];
		seen[0] = true;
		int player = players[0];
		while (true) {
			int nextPlayer = players[player];
			if (nextPlayer == 0) {
				System.out.println("YES");
				return;
			}
			if (seen[nextPlayer]) {
				System.out.println("NO");
				return;
			}
			seen[nextPlayer] = true;
			player = nextPlayer;
		}
	}

	public static void main(String args[]) {
		Football football = new Football();
		football.run();
	}
}
