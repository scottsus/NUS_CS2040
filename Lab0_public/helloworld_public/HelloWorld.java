import java.util.*;

public class HelloWorld {
    private void run() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line.equals("Hello World")) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }

        sc.close();
    }

    public static void main(String[] args) {
        HelloWorld helloworld = new HelloWorld();
        helloworld.run();
    }
}
