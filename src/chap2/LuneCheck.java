package chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LuneCheck {

	public static void main(String[] args) {
		int checkDigit = 3;
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums = oddEven();
		System.out.println(nums);
		String str = itos(nums);
		System.out.println(str);
		int[] numbers = stoi(str);
		System.out.println(Arrays.toString(numbers));
		int sum = arraySum(numbers);
		sum += checkDigit;
		System.out.println(sum);
		if (sum % 10 == 0) {
			System.out.println("認証成功");
		} else {
			System.out.println("値が不正です。");
		}

	}

	// 奇数用と偶数用の配列を作成
	static ArrayList<Integer> oddEven() {
		ArrayList<Integer> nums1 = new ArrayList<Integer>();// 奇数用の配列
		ArrayList<Integer> nums2 = new ArrayList<Integer>();// 偶数用の配列
		Scanner stdIn = new Scanner(System.in);

		System.out.println("数値を入力してください。終了したい場合は負の値を入力してください。");

		int x = 0;
		int y = 0;
		int num1 = 0;
		int num2 = 0;

		for (int i = 0; x > -1; i++) {
			System.out.println((i + 1) + "桁目");
			x = stdIn.nextInt();
			num1 = x;
			num2 = x;
			if (x < 0) {
				break;
			}
			if (i == 0 || (i % 2) == 0) {// 偶数なら偶数桁を倍にする
				num2 = (x * 2);
			}
			if (i == 1 || (i % 2) == 1) {// 奇数なら奇数桁を倍にする
				num1 = (x * 2);
			}
			nums1.add(num1);
			nums2.add(num2);
			y++;
		}
		if ((y % 2) == 0) {// 偶数なら
			return nums1;
		} else {// 奇数なら
			return nums2;
		}
	}

	// Integer配列をString配列に変換
	static String itos(ArrayList<Integer> nums) {
		String str = "";
		for (int i = 0; i < nums.size(); i++) {
			str += Integer.toString(nums.get(i));
		}
		return str;
	}

	// 文字列を一文字ずつに分割し数値配列に格納
	static int[] stoi(String str) {
		int leng = str.length();
		int[] nums = new int[leng];
		for (int i = 0; i < leng; i++) {
			nums[i] = Integer.parseInt("" + str.charAt(i));
		}
		return nums;
	}

	// 配列の値を合計
	static int arraySum(int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

}
