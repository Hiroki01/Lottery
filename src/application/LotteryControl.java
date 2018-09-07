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

	private List<Integer> hit = new ArrayList<Integer>();

	private int count = 0;

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
		//当たりの配列を作成、重複無し
	}

	public void event() {
//		label.setText(String.valueOf(list.get(count)));
		for(int BBB : hit) {
			if(BBB == list.get(count)) {
				label.setText("当たり～！！");
				break;
			}else {
				label.setText("外れ～！！");
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
