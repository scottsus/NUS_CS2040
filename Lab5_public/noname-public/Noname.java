import java.util.*;

public class Noname {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), T = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] + nums[j] <= T) {
                    set.add(List.of(i, j));
                }
            }
        }

        System.out.println(set.size());
    }

    public static void main(String args[]) {
        Noname runner = new Noname();
        runner.run();
    }
}
