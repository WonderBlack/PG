package chap2;

import java.util.Arrays;
import java.util.Scanner;

public class Encode {

	public static void main(String[] args) {

		System.out.println("暗号を解読します。暗号を入力してください。");
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.next();// 文字列を読み込み
		String[] str2 = str.split(",", -1);// 文字列を,で分割
		System.out.println("暗号の文字配列は：");
		System.out.println(Arrays.toString(str2)); 

		// 文字列配列を数値配列に変換
		int[] nums = new int[str2.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(str2[i]);
		}
		System.out.println("文字配列を下記の数値配列に変換しました：");
		System.out.println( Arrays.toString(nums));

		String message = surplus(nums);
		System.out.println("暗号");
		System.out.println( Arrays.toString(nums));
		System.out.println("の正体は↓");
		System.out.println(message);

	}

	// 数値の剰余を算出するメソッド
	static String surplus(int[] nums) {
		int mode = 0;
		int div;// 割る数
		int ans = 0;// 剰余
		String msg = "";
		for (int i = 0; i < nums.length; i++) {

			// modeが2の時のみ9で割る
			if (mode == 2) {
				div = 9;
			} else {
				div = 27;
			}

			// modeをループさせる
			ans = nums[i] % div;
			if (ans == 0) {
				mode++;
				System.out.println("モードが変わりました。");
			}
			if (mode > 2) {
				mode = 0;
			}
			

			// モードに応じてメソッドを選択し文字列にmsgに追加
			if (ans != 0) {// ansが0以外の時、すなわちモード切替以外の時
				System.out.print("現在のモードは" + mode);
				if (mode == 0) {// 大文字モードの場合
					System.out.println("追加する文字は" + Alp(ans));
					msg += Alp(ans);
				} else if (mode == 1) {// 子文字モードの場合
					System.out.println("追加する文字は" + alp(ans));
					msg += alp(ans);
				} else if (mode == 2) {// マークモードの場合
					System.out.println("追加する文字は" + mark(ans));
					msg += mark(ans);
				}
			}
		}
		return msg;
	}

	// 数値をアルファベットの大文字に変換するメソッド
	static String Alp(int n) {// nは剰余
		String Alp[] = { " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"X", "Y", "Z" };
		return Alp[n];
	}

	// 数値をアルファベットの小文字に変換するメソッド
	static String alp(int n) {
		String alp[] = { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z" };
		return alp[n];
	}

	// 数値を記号に変換するメソッド
	static String mark(int n) {
		String[] mark = { " ", "!", "?", ",", ".", " ", ";", "\"", "\"" };
		return mark[n];
	}
}
