import java.util.*;

public class Inversion {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int numSwaps = bubbleSort(nums);
        System.out.println(numSwaps);
    }

    public int bubbleSort(int[] nums) {
        int numSwaps = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                    numSwaps++;
                }
            }
        }

        return numSwaps;
    }

    public static void main(String[] args) {
        Inversion runner = new Inversion();
        runner.run();
    }
}