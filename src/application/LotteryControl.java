package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class LotteryControl {
	private final Random rand = new Random();

	private Button button;
	//ボタンで処理する用
	private Label label;
	//結果等の表示(当たりか外れか)
	private Label Vscore;
	//試案中（当たり数）
	private Label Lscore;
	//試案中（外れ数）
	private LotteryControl lc;
	//処理機構を記述するクラスの定義

	public LotteryControl(Label label, Label vscore, Label lscore) {
		this.label = label;
		this.Vscore = vscore;
		this.Lscore = lscore;
	}
	public Object keyTyped(KeyEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Object Pressed(ActionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
