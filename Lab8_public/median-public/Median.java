import java.util.*;

public class Median {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        MedianFinder mf = new MedianFinder();
        for (int i = 0; i < Q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int num = sc.nextInt();
                mf.offer(num);
            } else { // op == 2
                mf.printMedian();
            }
        }

        sc.close();
    }

    public static void main(String args[]) {
        Median runner = new Median();
        runner.run();
    }
}

class MedianFinder {
    Queue<Integer> left, right;

    MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Collections.reverseOrder());
    }

    void offer(int num) {
        if (left.isEmpty() || left.peek() < num) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    void printMedian() {
        if (left.size() > right.size()) {
            System.out.println(left.peek());
            return;
        }
        if (left.isEmpty() || right.isEmpty()) {
            System.out.println("None");
            return;
        }
        System.out.println(right.peek() + " " + left.peek());
    }
}