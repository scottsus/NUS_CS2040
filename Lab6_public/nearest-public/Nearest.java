import java.util.*;

public class Nearest {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            map.computeIfAbsent(num, x -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : map.values()) {
            Collections.sort(indices);
        }

        List<Integer> closestElements = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            List<Integer> indices = map.get(num);
            int closestIndex = getClosestIndex(i, indices);
            closestElements.add(closestIndex);
        }

        for (int elem : closestElements) {
            System.out.println(elem);
        }
    }

    public int getClosestIndex(int i, List<Integer> indices) {
        if (indices.size() == 1) {
            return -1;
        }

        int left = 0, right = indices.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (indices.get(mid) < i) {
                left = mid + 1;
            } else if (indices.get(mid) > i) {
                right = mid - 1;
            } else {
                break;
            }
        }

        int leftDistance = Integer.MAX_VALUE;
        if (mid > 0) {
            leftDistance = Math.abs(i - indices.get(mid - 1));
        }
        int rightDistance = Integer.MAX_VALUE;
        if (mid < indices.size() - 1) {
            rightDistance = Math.abs(i - indices.get(mid + 1));
        }

        return Math.min(leftDistance, rightDistance);
    }

    public static void main(String args[]) {
        Nearest runner = new Nearest();
        runner.run();
    }
}
