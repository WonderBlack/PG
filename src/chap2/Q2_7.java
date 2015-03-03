package chap2;

public class Q2_7 {
	public static void main(String[] args) {

		int x = 8;
		int y = 3;
		int z = 2;

		for (int i = 0; i < 4; i++) {

			// スペースを出力
			for (int j = 0; j < y; j++) {
				System.out.print(" ");

			}
			y--;

			// #を出力
			for (int j = 0; j < z; j++) {
				System.out.print("#");
			}
			z += 2;
			System.out.println();

		}

		for (int i = 0; i < 4; i++) {

			// スペースを出力
			for (int j = 0; j < i; j++) {
				if (i > 0) {
					System.out.print(" ");
				}
			}

			// #を出力
			for (int j = 0; j < x; j++) {
				System.out.print("#");
			}
			x -= 2;
			System.out.println();

		}

	}
}
