package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.control.Label;

public class LotteryControl {
//	private final Random rand = new Random();

	private static final int[] Hit = {
			367, 181, 1, 237, 23, 101, 467, 333, 65, 47, 433, 322, 261, 244, 86, 44, 322, 157, 157, 475, 329, 292, 25,
			436, 366, 348, 261, 456, 403, 52, 341, 100, 222, 349, 403, 186, 428, 323, 249, 84, 443, 434, 56, 246, 152,
			354, 13, 161, 261, 32, 353, 32, 334, 324, 294, 163, 408, 309, 82, 220, 36, 140, 12, 310, 74, 337, 225, 247,
			281, 78, 134, 210, 22, 494, 395, 138, 130, 211, 185, 4, 54, 449, 233, 496, 290, 384, 89, 41, 110, 468, 220,
			8, 379, 48, 82, 2, 205, 128, 78, 295, 123, 112, 475, 320, 371, 430, 322, 264, 153, 188, 154, 207, 89, 284,
			171, 31, 43, 124, 209, 497, 462, 14, 17, 457, 326, 229, 446, 462, 237, 179, 446, 336, 398, 307, 420, 87, 88,
			423, 306, 136, 249, 235, 403, 488, 110, 135, 411, 363, 272, 468, 64, 203, 485, 14, 429, 362, 221, 91, 10,
			460, 5, 465, 430, 171, 373, 369, 53, 445, 478, 264, 94, 88, 371, 324, 318, 278, 105, 253, 287, 214, 223,
			132, 308, 139, 108, 237, 98, 188, 239, 158, 288, 498, 449, 174, 192, 431, 313, 348, 249, 208, 334, 473, 58,
			82, 71, 129, 469, 405, 319, 87, 101, 117, 404, 71, 97, 202, 309, 362, 114, 391, 245, 13, 173, 167, 444, 387,
			326, 365, 489, 385, 281, 43, 266, 499, 354, 238, 84, 285, 72, 253, 302, 471, 76, 267, 117, 387, 241, 110,
			153, 114
	};
	private Label label;
	//結果等の表示(当たりか外れか)
	private List<Integer> list = new ArrayList<Integer>();
	//くじ全体数リスト
//	private List<Integer> hit = new ArrayList<Integer>();
	//当たり用リスト
	private int count = 0;

	//実行時ｎ番目の数値を取り出すのに使用
	public LotteryControl(Label label) {
		this.label = label;

	}

	public void setArray() {
		for (int i = 1; i <= 500; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		//くじの配列作成およびシャッフル

//		hit.addAll();
//
//		for (int j = 1; j <= 50; j++) {
//			int dynabook = rand.nextInt(100);
//			for (int AAA : hit) {
//				if (dynabook == AAA) {
//					continue;
//				}
//			}
//			hit.add(dynabook);
//			System.out.println(dynabook);
//		}
//		Collections.shuffle(hit);
//		//当たりの配列を作成、重複無し
	}

	public void event(int countHit1, int countHit2, int countHit3, int disengagement) {//当たり、外れの判定メソッド
		for (int BBB : Hit) {
			if (BBB == list.get(count)) {
				if (BBB < 400) {
					label.setText("1等");
					System.out.println(BBB);
					break;
				} else{
					label.setText("当たり～！！");
					System.out.println(BBB);
					break;
					//当たりリストの中にあったら当たりと表示し、処理終了
				}
			} else if (BBB != list.get(count)) {
				label.setText("外れ～！！");
				//なかったら外れと表示
			} else {
				System.out.println("なかったね");
			}
		}
		//当たり番号を格納してある配列と同じ数値があるかの判定
		count++;
		if (count >= 100) {
			count = 0;
		}
		//100回実行したらリセット
		//この場所の修正次第で最大くじ回数の指定可能

	}

}
