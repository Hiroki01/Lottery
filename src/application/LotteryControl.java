package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LotteryControl {

	private static final int[][] Hit = {
			{ 1, 3, 5, 7 },
			{ 12, 14, 15, 17, 18, 21, 23, 25, 26, 27, 29, 30, 31, 36, 37, 39 },
			{ 50, 51, 52, 54, 58, 59, 60, 62, 64, 65, 68, 69, 71, 73, 74,
				76, 77, 79, 82, 84, 85, 86, 88, 89, 92, 93, 95, 96, 97, 100 }
	};
	//当たりの配列
	private List<Integer> list = new ArrayList<Integer>();
	//くじ全体数リスト
	private int count = 0;

	void setArray() {
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		//くじの配列作成およびシャッフル

	}

	String event() {//当たり、外れの判定メソッド
		String result = null;
		int place = 0;
		A:for (int[] BBB : Hit) {
			for (int CCC : BBB) {
				if (CCC == list.get(count)) {
					//引いた数字があったらtrue
					if (place == 0) {
						result = "１等です！\nおめでとうございます！";
						break A;
					} else if (place == 1) {
						result = "２等です！\nおめでとうございます！";
						place = 0;
						break A;
						//当たりリストの中にあったら当たりと表示し、処理終了
					} else if (place == 2) {
						result = "３等です！\nおめでとうございます！";
						place = 0;
						break A;
					} else {
						break;
					}
				} else if (CCC != list.get(count)) {
					result = "残念！はずれです！\nまた挑戦してくださいね！！";
				}
			}
			place++;
		}
		//当たり番号を格納してある配列と同じ数値があるかの判定
		count++;
		if (count >= 100){
			count = 0;
		}
		//100回実行したらリセット
		//この場所の修正次第で最大くじ回数の指定可能

		return result;
	}


}
