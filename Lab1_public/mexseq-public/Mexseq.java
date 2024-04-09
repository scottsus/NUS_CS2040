import java.util.*;

public class Mexseq {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), target = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int MAX_X = 500; // from the question
		int[] map = new int[MAX_X + 1];
		Arrays.fill(map, -1);

		int numTargetCopies = 0;
		for (int num : arr) {
			if (num == target) {
				numTargetCopies++;
			}
			map[num] = num;
		}

		int numOps = 0;
		for (int i = 0; i < map.length; i++) {
			if (i == target) {
				break;
			}
			if (map[i] == -1) {
				numOps++;
			}
		}

		numOps += numTargetCopies;
		System.out.println(numOps);

		sc.close();
	}

	public static void main(String[] args) {
		Mexseq newMexseq = new Mexseq();
		newMexseq.run();
	}
}
