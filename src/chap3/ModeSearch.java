package chap3;

import java.util.Arrays;
import java.util.Scanner;

//文章中に最も多く登場したデータを調べる
public class ModeSearch {
	public static void main(String[] args) {
		System.out.println("複数の単語をスペースで区切り入力してください。");
		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();// 文字列を読み込み
		str = str.replaceAll("[,.;:!?\n]", " ");// 記号を除去
		System.out.println(str);

		modeSearch(str);
	}

	static void modeSearch(String s) {
		String[] str1 = s.split(" ", -1);// 文字列を,で分割
		String[] str2 = (String[]) str1.clone();// 配列をコピー
		int[] count = new int[str1.length];// 各単語の出現回数を保持
		
		Arrays.fill(count, 0);

		// 単語の出現回数をカウント
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str1.length; j++) {
				if (str1[i].equals(str2[j])) {
					count[i]++;
				}
			}
		}
		System.out.println("単語の出現回数をカウント");
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(count));
		
		// 重複を削除
		for (int i = 0; i < str1.length; i++) {
			for (int j = i + 1; j < str1.length; j++) {
				if (str1[i].equals(str2[j])) {
					str2[j] = "";
					count[j] = 0;
				}
			}
		}
		System.out.println("重複を削除");
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(count));
		
		int max = count[0];
		int pos = 0;
		for (int i = 1; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				pos = i;
			}
		}
		
		System.out.println("再頻出単語は" + str1[pos] + "で出現回数は" + max + "です。");

	}

}
