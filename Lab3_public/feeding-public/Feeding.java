import java.util.*;

public class Feeding {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();

		int[] fishes = new int[N];
		for (int i = 0; i < N; i++) {
			fishes[i] = sc.nextInt();
		}

		int[] newFishes = new int[M];
		for (int i = 0; i < M; i++) {
			newFishes[i] = sc.nextInt();
		}
		sc.close();

		Deque<Long> q = new LinkedList<>();
		for (int fish : fishes) {
			q.offerLast((long) fish);
		}

		for (long newFish : newFishes) {
			while (!q.isEmpty() && newFish > q.peek()) {
				newFish += q.pollFirst();
			}
			q.offerFirst(newFish);
		}

		StringJoiner sj = new StringJoiner(" ");
		while (!q.isEmpty()) {
			sj.add(q.poll().toString());
		}
		System.out.println(sj.toString());
	}

	public static void main(String args[]) {
		Feeding feeding = new Feeding();
		feeding.run();
	}
}
