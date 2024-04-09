import java.util.*;

public class Website {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();

        Map<String, Map<String, Integer>> countries = new HashMap<>();
        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String country = "";

            switch (Integer.valueOf(parts[0])) {
                case 1:
                    String ip = parts[1];
                    country = parts[2];
                    int duration = Integer.valueOf(parts[3]);

                    if (!countries.containsKey(country)) {
                        countries.put(country, new HashMap<>());
                    }
                    Map<String, Integer> case1Ips = countries.get(country);
                    case1Ips.put(ip, case1Ips.getOrDefault(ip, 0) + duration);

                    break;
                case 2:
                    country = parts[1];
                    int maxDuration = 0;
                    Map<String, Integer> case2Ips = countries.get(country);
                    if (case2Ips == null) {
                        System.out.println(0);
                    } else {
                        for (int ipDuration : case2Ips.values()) {
                            maxDuration = Math.max(ipDuration, maxDuration);
                        }
                        System.out.println(maxDuration);
                    }

                    break;
                case 3:
                    int numCountriesWithIp = 0;
                    for (Map<String, Integer> case3Ips : countries.values()) {
                        if (case3Ips != null) {
                            numCountriesWithIp++;
                        }
                    }
                    System.out.println(numCountriesWithIp);

                    break;
                case 4:
                    country = parts[1];
                    Map<String, Integer> case3Ips = countries.get(country);
                    if (case3Ips == null) {
                        System.out.println(0);
                    } else {
                        System.out.println(case3Ips.keySet().size());
                    }
                    break;
            }
        }

        sc.close();
    }

    public static void main(String[] args) {
        Website website = new Website();
        website.run();
    }
}
