package chap2;

import java.util.Arrays;
import java.util.Scanner;

public class LuneCheckSum {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("何桁の番号を入力しますか？");
		int num = stdIn.nextInt();
		int[] nums = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "桁目の番号を入力してください");
			nums[i] = stdIn.nextInt();
		}
		System.out.println(Arrays.toString(nums));
		
		int flg = lck(nums, num);
		if (flg == 1) {
			System.out.println("認証が完了しました。");
		} else if (flg == -1) {
			System.out.println("値が不正です。");
		}

	}

	static int lck(int[] x, int num) {
		if (num % 2 == 0) {// 偶数桁なら１桁目から一個おきに倍にする
			for (int i = 0; i < x.length; i += 2) {
				x[i] = x[i] * 2;
			}
		} else {// 奇数桁なら２桁目から一個おきに倍にする
			for (int i = 1; i < x.length; i += 2) {
				x[i] = x[i] * 2;
			}
		}

		// 配列の中身の数字を一続きの文字列に変換
		String str = "";
		for (int i = 0; i < x.length; i++) {
			str += Integer.toString(x[i]);
		}
		System.out.println(str);
		System.out.println(str.length());

		// 文字列を一文字ずつに分割し数値配列に格納
		int num2 = str.length();
		int[] nums3 = new int[num2];
		System.out.println(Arrays.toString(nums3));
		for (int i = 0; i < num2; i++) {
			nums3[i] = Integer.parseInt("" + str.charAt(i));
		}
		System.out.println(Arrays.toString(nums3));
		// 配列の値を合計
		int sum = 0;
		for (int i = 0; i < nums3.length; i++) {
			sum += nums3[i];
			System.out.println(sum);
		}
		
		if ((sum % 10) == 0) {
			return 1;
		} else {
			return -1;
		}

	}

}
