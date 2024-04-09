import java.util.*;

public class Jobs {
    long minTimeNeeded = Long.MAX_VALUE;

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] jobs = new int[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = sc.nextInt();
        }
        sc.close();

        int numWorkers = 3;
        long[] workers = new long[numWorkers];

        assignJobs(jobs, workers, 0);
        System.out.println(minTimeNeeded);
    }

    public void assignJobs(int[] jobs, long[] workers, int jobNum) {
        if (jobNum == jobs.length) {
            minTimeNeeded = Math.min(calcMax(workers), minTimeNeeded);
            return;
        }

        int job = jobs[jobNum];
        for (int i = 0; i < workers.length; i++) {
            workers[i] += job;
            assignJobs(jobs, workers, jobNum + 1);
            workers[i] -= job;
        }
    }

    public long calcMax(long[] nums) {
        long max = 0;
        for (long num : nums) {
            max = Math.max(num, max);
        }

        return max;
    }

    public static void main(String args[]) {
        Jobs runner = new Jobs();
        runner.run();
    }
}
