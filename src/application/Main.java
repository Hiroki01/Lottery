package application;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	Alert alert;
	//アラート用
	private Label label;
	//結果等の表示(当たりか外れか)
	private LotteryControl lc;
	//クラス呼びだし
	//結果表示待機画面

	//処理機構を記述するクラスの定義
	@Override
	public void start(Stage stage) {
		stage.setFullScreen(true);
		//GUIタイトル、画面幅、高さ指定
		alert = new Alert(AlertType.INFORMATION);
		try {

			myLayout(stage);
			//各種配置等決定用
			stage.show();
			//GUI起動
			lc = new LotteryControl();
			//処理中に変更が必要なものをコンストラクタで送る
			lc.setArray();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		//例外処理
	}

	private void myLayout(Stage stage) {
		//レイアウト用メソッド
		Font font = new Font("東青梅ゴシック", 40);
		//ボタン
		label = new Label("ここに結果が出るよ♪");
		label.setPrefSize(509,400);
		label.setFont(font);
		label.setAlignment(Pos.CENTER);
		//結果表示用ラベル


		AnchorPane anc = new AnchorPane();
		anc.setId("anc");
		AnchorPane.setTopAnchor(label, 60.0);
	     AnchorPane.setLeftAnchor(label, 450.0);
	     anc.getChildren().addAll(label);

		Scene scene = new Scene(anc);
		//配置方法指定

		scene.setOnKeyPressed(event -> {
			//システムシャットダウン(Escキーで)
			if(event.getCode().equals(KeyCode.ESCAPE)){
				System.exit(0);
			}

			if(event.getCode().equals(KeyCode.ENTER)){
				Thread th = new Thread(new Runnable() {

					@Override
					public void run() {
						Platform.runLater(
								() -> label.setText("結果は"));
						//MP3を再生
						AudioClip dramRoll = new AudioClip(new File("dramroll.mp3").toURI().toString());
						dramRoll.play();

						int j =0;
						while(j<4){
							Platform.runLater(
									() -> label.setText(label.getText()+"・"));
							try {
								if(j!=3){
									Thread.sleep(1000);//1秒停止
								}else{
									Platform.runLater(
											() -> label.setText(lc.event()));
									Thread.sleep(4000);//2.5秒停止
									Platform.runLater(
											() -> label.setText("ここに結果が出るよ♪"));
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							j++;
						}

					}
				});
				th.start();
			}
		});

		//エンターキーが押されたときの処理
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//cssで細かい表示形式設定
		stage.setScene(scene);
		//ステージセット

	}

	public static void main(String[] args) {
		launch(args);
		//起動
	}
}
