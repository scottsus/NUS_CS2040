import java.util.*;

public class Cake {
	private void run() {
		/**
		 * Core idea: a shorter column will never increase the area
		 * if we encounter a shorter column, "cash out" and calc area
		 * maxArea will come from monotonically increasing regions
		 * just need to maintain a list of heights to calculate the minHeight
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = sc.nextInt();
		}
		sc.close();

		long maxArea = 0;
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N + 1; i++) {
			int height = i != N ? heights[i] : 0;
			int prevIndexWithSameHeight = i;
			while (!stack.isEmpty() && height < stack.peek()[1]) {
				int[] tup = stack.pop();
				prevIndexWithSameHeight = tup[0];
				int width = i - prevIndexWithSameHeight;
				long area = (long) tup[1] * width;
				maxArea = Math.max(area, maxArea);
			}
			stack.push(new int[] { prevIndexWithSameHeight, height });
		}

		System.out.println(maxArea);
	}

	public static void main(String args[]) {
		Cake cake = new Cake();
		cake.run();
	}
}
