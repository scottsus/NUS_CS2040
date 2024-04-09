import java.util.*;

public class Transpose {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt(), C = sc.nextInt();
		sc.nextLine(); // flush the buffer

		char[][] matrix = new char[R][C];
		for (int i = 0; i < R; i++) {
			String row = sc.nextLine();
			for (int j = 0; j < C; j++) {
				matrix[i][j] = row.charAt(j);
			}
		}

		char[][] transposed = new char[C][R];
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				transposed[j][i] = matrix[i][j];
			}
		}

		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				System.out.print(transposed[j][i]);
			}
			System.out.println();
		}

		sc.close();
	}

	public static void main(String[] args) {
		Transpose newTranspose = new Transpose();
		newTranspose.run();
	}
}
