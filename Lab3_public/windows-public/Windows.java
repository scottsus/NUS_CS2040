import java.util.*;

public class Windows {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> oddElements = new ArrayList<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < N; windowEnd++) {
            if (windowEnd - windowStart + 1 == K) {
                int leftMostOdd = getLeftMostOdd(nums, windowStart, windowEnd);
                oddElements.add(leftMostOdd);
                windowStart++;
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int oddElement : oddElements) {
            sj.add(String.valueOf(oddElement));
        }
        System.out.println(sj.toString());
    }

    public int getLeftMostOdd(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 == 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Windows windows = new Windows();
        windows.run();
    }
}
