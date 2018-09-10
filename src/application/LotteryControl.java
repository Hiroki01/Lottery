package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Label;

public class LotteryControl {
	private final Random rand = new Random();

	private Label label;
	//結果等の表示(当たりか外れか)
	private List<Integer> list = new ArrayList<Integer>();
	//くじ全体数リスト
	private List<Integer> hit = new ArrayList<Integer>();
	//当たり用リスト
	private int count = 0;
	//実行時ｎ番目の数値を取り出すのに使用
	public LotteryControl(Label label) {
		this.label = label;

	}

	public void setArray() {
		for(int i = 1;i <= 100 ;i ++) {
			list.add(i);
		}
		Collections.shuffle(list);
		//くじの配列作成およびシャッフル

		for(int j = 1 ; j <= 50 ; j++) {
			int dynabook = rand.nextInt(100);
			for(int AAA : hit) {
				if(dynabook == AAA) {
					continue;
				}
			}
			hit.add(dynabook);
		}
		Collections.shuffle(hit);
		//当たりの配列を作成、重複無し
	}

	public void event() {//当たり、外れの判定メソッド
		for(int BBB : hit) {
			if(BBB == list.get(count)) {
				label.setText("当たり～！！");
				break;
				//当たりリストの中にあったら当たりと表示し、処理終了
			}else {
				label.setText("外れ～！！");
				//なかったら外れと表示
			}
		}
		//当たり番号を格納してある配列と同じ数値があるかの判定、あった場合当たり
		count++;
		if(count >= 100) {
			count = 0;
		}
		//100回実行したらリセット

	}

}
