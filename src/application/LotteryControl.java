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
	private Label Vscore;
	//試案中（当たり数）
	private Label Lscore;
	//試案中（外れ数）
	private LotteryControl lc;
	//処理機構を記述するクラスの定義
	private List<Integer> list = new ArrayList<Integer>();

	private List<Integer> hit = new ArrayList<Integer>();

	private int count = 0;

	public LotteryControl(Label label, Label vscore, Label lscore) {
		this.label = label;
		this.Vscore = vscore;
		this.Lscore = lscore;
	}

	public void setArray() {
		for(int i = 1;i <= 100 ;i ++) {
			list.add(i);
		}
		Collections.shuffle(list);

		for(int j = 1 ; j <= 50 ; j++) {
			int dynabook = rand.nextInt(100);
			for(int AAA : hit) {
				if(dynabook == AAA) {
					continue;
				}
			}
			hit.add(dynabook);
		}
	}

	public void event() {
//		label.setText(String.valueOf(list.get(count)));
		for(int BBB : hit) {
			if(BBB == list.get(count)) {
				label.setText("当たり～！！");
				System.out.println(list.get(count));
				System.out.println(BBB);
				break;
			}else {
				label.setText("外れ～！！");
			}
		}
		count++;
		if(count >= 100) {
			count = 0;
		}

	}

//	private void judgment() {
//
//	}

}
