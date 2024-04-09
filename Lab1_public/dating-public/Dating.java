import java.util.*;

public class Dating {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int totalWaitTime = 0, numMatched = 0;
        Queue<Person> maleQ = new LinkedList<>();
        Queue<Person> femaleQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String request = sc.nextLine();
            String[] parts = request.split(" ");
            String gender = parts[0], name = parts[1];

            if (gender.equals("MALE")) {
                if (!femaleQ.isEmpty()) {
                    Person female = femaleQ.poll();
                    System.out.println(name + " matches " + female.name);

                    int timeWaited = i - female.startTime;
                    totalWaitTime += timeWaited;
                    numMatched += 2;
                } else {
                    Person male = new Person(name, i);
                    maleQ.offer(male);
                }
            } else { // gender == "FEMALE"
                if (!maleQ.isEmpty()) {
                    Person male = maleQ.poll();
                    System.out.println(male.name + " matches " + name);

                    int timeWaited = i - male.startTime;
                    totalWaitTime += timeWaited;
                    numMatched += 2;
                } else {
                    Person female = new Person(name, i);
                    femaleQ.offer(female);
                }
            }
        }

        double averageWaitTime = 0;
        if (numMatched > 0) {
            averageWaitTime = (double) totalWaitTime / numMatched;
        }
        System.out.printf("%.2f\n", averageWaitTime);

        sc.close();
    }

    public static void main(String[] args) {
        Dating dating = new Dating();
        dating.run();
    }
}

class Person {
    String name;
    int startTime;

    Person(String name, int startTime) {
        this.name = name;
        this.startTime = startTime;
    }
}
