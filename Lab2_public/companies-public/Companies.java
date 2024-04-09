import java.util.*;

public class Companies {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int totalEngineers = sc.nextInt();
		int totalCompanies = sc.nextInt();

		List<List<Integer>> companies = new ArrayList<>();
		for (int i = 0; i < totalCompanies; i++) {
			int numEngineers = sc.nextInt();
			List<Integer> engineers = new ArrayList<>();
			for (int j = 0; j < numEngineers; j++) {
				engineers.add(sc.nextInt());
			}
			companies.add(engineers);
		}

		int numTransactions = sc.nextInt();
		for (int i = 0; i < numTransactions; i++) {
			int predator = sc.nextInt(), prey = sc.nextInt();
			List<Integer> predatorEngineers = companies.get(predator);
			List<Integer> preyEngineers = companies.get(prey);
			predatorEngineers.addAll(preyEngineers);
			companies.set(prey, null);
		}

		int numCompaniesLeft = 0;
		for (List<Integer> engineers : companies) {
			if (engineers != null) {
				numCompaniesLeft++;
			}
		}
		System.out.println(numCompaniesLeft);

		for (int i = 0; i < companies.size(); i++) {
			List<Integer> engineers = companies.get(i);
			if (engineers == null) {
				continue;
			}
			int numEngineers = engineers.size();
			Collections.sort(engineers);
			System.out.print(i + " " + numEngineers);
			for (int engineer : engineers) {
				System.out.print(" " + engineer);
			}
			System.out.println();
		}

		sc.close();
	}

	public static void main(String args[]) {
		Companies companies = new Companies();
		companies.run();
	}
}
