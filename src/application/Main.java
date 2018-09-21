package application;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	static boolean flg = false;
	private Label label;
	// 結果等の表示(当たりか外れか)
	private LotteryControl lc;
	// クラス呼びだし
	@Override
	public void start(Stage stage) {
		stage.setFullScreen(true);
		// GUIタイトル、画面幅、高さ指定
		try {

			myLayout(stage);
			// 各種配置等決定用
			stage.show();
			// GUI起動
			lc = new LotteryControl();
			// 処理中に変更が必要なものをコンストラクタで送る
			lc.setArray();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("何かがおかしいよ");
		}
		// 例外処理
	}

	private void myLayout(Stage stage) {
		// レイアウト用メソッド
		Font font = new Font("東青梅ゴシック", 40);
		// ボタン
		label = new Label("ここに結果が出るよ♪");
		label.setPrefSize(509, 400);
		label.setFont(font);
		label.setAlignment(Pos.CENTER);
		// 結果表示用ラベル

		AnchorPane root = new AnchorPane();
		root.setId("root");
		AnchorPane.setTopAnchor(label, 60.0);
		AnchorPane.setLeftAnchor(label, 450.0);
		root.getChildren().add(label);
		Scene scene = new Scene(root);

		scene.setOnKeyPressed(event -> {
			// システムシャットダウン(Escキーで)
			if (event.getCode().equals(KeyCode.ESCAPE)) {
				System.exit(0);
			}
			// エンターキーが押されたときの処理
			if (!flg) {
				flg = true;
				if (event.getCode().equals(KeyCode.ENTER)) {

					Thread th = new Thread(new Runnable() {

						@Override
						public void run() {
							Platform.runLater(() -> label.setText("結果は"));
							// MP3を再生
							AudioClip dramRoll = new AudioClip(new File("dramroll.mp3").toURI().toString());
							dramRoll.play();

							int j = 0;
							while (j < 4) {//・・・の表示
								Platform.runLater(() -> label.setText(label.getText() + "・"));

								try {
									if (j != 3) {
										Thread.sleep(1000);// 1秒停止

									} else {
										String keyword = lc.event();
										Platform.runLater(() -> label.setText(keyword));
										if("１等です！\nおめでとうございます！".equals(keyword)){
											dramRoll.stop();
											AudioClip sound = new AudioClip(new File("sound1.mp3").toURI().toString());
											sound.play();
											Thread.sleep(6000);// 6秒停止

										}else if("２等です！\nおめでとうございます！".equals(keyword)){
											dramRoll.stop();
											AudioClip sound = new AudioClip(new File("oruga.mp3").toURI().toString());
											sound.play();
											Thread.sleep(9000);// 9秒停止

										}else if("３等です！\nおめでとうございます！".equals(keyword)){
											dramRoll.stop();
											AudioClip sound = new AudioClip(new File("dragon.mp3").toURI().toString());
											sound.play();
											Thread.sleep(3000);// 3秒停止

										}else{
											Thread.sleep(2000);// 2秒停止

										}
										Platform.runLater(() -> label.setText("ここに結果が出るよ♪"));
										flg=false;
									}

								} catch (InterruptedException e) {
									e.printStackTrace();
									System.out.println("何かがおかしいよ");
								}
								j++;
							}

						}
					});
					th.start();
				}
			}
		});
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// cssで細かい表示形式設定
		stage.setScene(scene);
		// sceneをstageにセットする

	}

	public static void main(String[] args) {
		launch(args);
		// 起動
	}
}
