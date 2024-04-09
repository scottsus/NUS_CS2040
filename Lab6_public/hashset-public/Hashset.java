import java.util.*;

public class Hashset {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
        }

        Map<Integer, Map<Integer, Integer>> mapA = constructMap(a);
        Map<Integer, Map<Integer, Integer>> mapB = constructMap(b);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int L = sc.nextInt(), R = sc.nextInt();
            int U = sc.nextInt(), V = sc.nextInt();

            Map<Integer, Integer> subMapA = getSubMap(mapA, L, R);
            Map<Integer, Integer> subMapB = getSubMap(mapB, U, V);

            // System.out.println(subMapA.toString());
            // System.out.println(subMapB.toString());

            if (isEqualMultiset(subMapA, subMapB)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        sc.close();
    }

    public Map<Integer, Map<Integer, Integer>> constructMap(int[] nums) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> currMap = null;
            if (i == 0) {
                currMap = new HashMap<>();
            } else {
                currMap = new HashMap<>(map.get(i - 1));
            }

            int num = nums[i];
            currMap.put(num, currMap.getOrDefault(num, 0) + 1);
            map.put(i, currMap);
        }

        return map;
    }

    public Map<Integer, Integer> getSubMap(Map<Integer, Map<Integer, Integer>> map, int L, int R) {
        if (L == 1) {
            return new HashMap<>(map.get(R - 1));
        }
        Map<Integer, Integer> mapL = map.get(L - 2);
        Map<Integer, Integer> mapR = map.get(R - 1);
        Map<Integer, Integer> subMap = new HashMap<>(mapR);
        for (Map.Entry<Integer, Integer> entry : mapL.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            subMap.put(num, subMap.get(num) - freq);
            if (subMap.get(num) == 0) {
                subMap.remove(num);
            }
        }

        return subMap;
    }

    public boolean isEqualMultiset(Map<Integer, Integer> mapA, Map<Integer, Integer> mapB) {
        if (mapA.keySet().size() != mapB.keySet().size()) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entryA : mapA.entrySet()) {
            int num = entryA.getKey(), freqA = entryA.getValue();
            if (mapB.getOrDefault(num, -1) != freqA) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        Hashset runner = new Hashset();
        runner.run();
    }
}
