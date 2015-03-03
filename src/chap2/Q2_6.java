package chap2;

public class Q2_6 {
	public static void main(String[] args) {

		int x = 8;

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
