import java.util.*;

public class Bigcal {
    public void run() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine(), b = sc.nextLine();

        /**
         * 1. match lengths of a and b
         * 2. check for carry
         * 3. keep adding from right to left
         */
        int lengthDiff = Math.abs(a.length() - b.length());
        String zerosPadding = "";
        for (int i = 0; i < lengthDiff; i++) {
            zerosPadding += "0";
        }
        if (a.length() < b.length()) {
            a = zerosPadding + a;
        } else {
            b = zerosPadding + b;
        }

        int N = a.length();
        String ans = "";

        int carry = 0;
        for (int i = N - 1; i >= 0; i--) {
            int aNum = Character.getNumericValue(a.charAt(i));
            int bNum = Character.getNumericValue(b.charAt(i));
            int sum = aNum + bNum + carry;
            carry = sum / 10;
            sum %= 10;
            ans = sum + ans;
        }

        if (carry == 1) {
            ans = "1" + ans;
        }
        System.out.println(ans);

        sc.close();
    }

    public static void main(String[] args) {
        Bigcal newBigcal = new Bigcal();
        newBigcal.run();
    }
}
