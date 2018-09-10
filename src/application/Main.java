package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	Alert alert;
	//アラート用
	private Button button;
	//ボタンで処理する用
	private Label label;
	//結果等の表示(当たりか外れか)
	private LotteryControl lc;

	//処理機構を記述するクラスの定義
	@Override
	public void start(Stage stage) {
		stage.setTitle("クジ引き");
		stage.setWidth(500);
		stage.setHeight(400);
		//タイトル、画面幅、高さ指定
		alert = new Alert(AlertType.INFORMATION);
		try {

			myLayout(stage);
			//各種配置等決定用
			stage.show();
			//GUI起動

			lc = new LotteryControl(label);
			//処理中に変更が必要なものをコンストラクタで送る
			lc.setArray();

			button.setOnAction(event -> lc.event());
			//ボタンが押された時用の処理

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		//例外処理
	}

	private void myLayout(Stage stage) {
		//レイアウト用メソッド
		Font font = new Font("MS ゴシック", 20);
		//フォント指定
		button = new Button("くじ");
		button.setPrefSize(100, 20);
		button.setFont(font);
		//ボタン
		label = new Label("ここに結果が出るよ♪");
		label.setPrefSize(200, 200);
		label.setFont(font);
		//結果表示用ラベル

		VBox vbox = new VBox();
		//hboxの配置位置
		vbox.setAlignment(Pos.CENTER);

		//HBOXと周囲のコントロールとの隙間
		vbox.setPadding(new Insets(10, 10, 10, 10));
		//hboxに配置するコントロールの隙間
		vbox.setSpacing(10);
		//hboxにコントロールを設置
		vbox.getChildren().addAll(label);

		Scene scene = new Scene(vbox);
		//配置方法指定

		scene.setOnKeyPressed(event -> lc.event());
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
