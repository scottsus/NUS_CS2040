import java.util.*;

public class Zero {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();

		int[] sums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}

		long numZeros = 0;
		for (int i = 0; i < sums.length - 1; i++) {
			for (int j = i + 1; j < sums.length; j++) {
				if ((sums[j] - sums[i]) == 0) {
					numZeros++;
				}
			}
		}

		System.out.println(numZeros);
	}

	public static void main(String args[]) {
		Zero runner = new Zero();
		runner.run();
	}
}
