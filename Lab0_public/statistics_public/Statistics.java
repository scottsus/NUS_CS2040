import java.util.*;

public class Statistics {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextLong();
		}

		long sum = 0;
		for (long num : nums) {
			sum += num;
		}

		double average = (double) sum / N;
		System.out.printf("Sum: %d\n", sum);
		System.out.printf("Average: %.2f\n", average);

		sc.close();
	}

	public static void main(String[] args) {
		Statistics newStatistics = new Statistics();
		newStatistics.run();
	}
}
