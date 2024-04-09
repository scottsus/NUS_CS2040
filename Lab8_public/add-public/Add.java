import java.util.*;

public class Add {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < Q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                q.offer(sc.nextInt());
            } else if (op == 2) {
                int x = sc.nextInt();
                int size = q.size();
                int[] buffer = new int[size];
                for (int j = 0; j < size; j++) {
                    buffer[j] = q.poll() + x;
                }
                for (int num : buffer) {
                    q.offer(num);
                }
            } else { // op == 3
                Integer ans = q.poll();
                System.out.println(ans != null ? ans : "None");
            }
        }

        sc.close();
    }

    public static void main(String args[]) {
        Add runner = new Add();
        runner.run();
    }
}
