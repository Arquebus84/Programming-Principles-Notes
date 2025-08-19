package EventHandlerEx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.*;

import javafx.scene.layout.*;

import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Microwave extends Application{
	/** Example of clicking the 9 button
				[9:99]

			1		2		3
			4		5		6
			7		8		9
			Start	30	Cancel
	 */
	
	ArrayList<Integer> timer;
	Label labelTimer;
	StringBuilder strTimer;
	
	
	@SuppressWarnings({ "exports" })
	@Override
	public void start(Stage stage) {
		GridPane gPane = new GridPane();

		//Buttons
		Button[] buttons = new Button[12];
		buttons[0] = new Button("1");
		buttons[1] = new Button("2");
		buttons[2] = new Button("3");
		buttons[3] = new Button("4");
		buttons[4] = new Button("5");
		buttons[5] = new Button("6");
		buttons[6] = new Button("7");
		buttons[7] = new Button("8");
		buttons[8] = new Button("9");
		buttons[9] = new Button("Start");
		buttons[10] = new Button("+30");
		buttons[11] = new Button("Cancel");

		//Font
		Font font = new Font("Times New Roman", 15);

		for (Button b : buttons) {
			b.setFont(font);
			b.setPrefSize(100, 50);
		}

		//Timer Text
		timer = new ArrayList<>();
		labelTimer = new Label();
		strTimer = new StringBuilder("00:00");

		//Update Label
		labelTimer.setTranslateX(100);
		labelTimer.setTranslateY(25);
		labelTimer.setScaleX(3);
		labelTimer.setScaleY(3);
		labelTimer.setFont(font);

		labelTimer.setText(strTimer.toString());

		//EventHandle for buttons:
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnAction(e -> {
				// System.out.println("Button " + ((Button) e.getSource()).getText() + " was clicked");

				switch (((Button) e.getSource()).getText()) {
					case "1": addInt(1); break;
					case "2": addInt(2); break;
					case "3": addInt(3); break;
					case "4": addInt(4); break;
					case "5": addInt(5); break;
					case "6": addInt(6); break;
					case "7": addInt(7); break;
					case "8": addInt(8); break;
					case "9": addInt(9); break;
					case "+30": addInt(3); addInt(0); System.out.println("+30"); break;
				}				
				
				// Update timer elements
				for (int n : timer) {
					System.out.print(n);
				}
						
				switch(timer.size()) {
					case 1: strTimer.replace(4,strTimer.length(), timer.get(0) + ""); break;
					case 2: strTimer.replace(3,strTimer.length(), timer.get(0) + "" + timer.get(1)); break;
					case 3: strTimer.replace(0,strTimer.length(), timer.get(0) + "" + timer.get(1) + ":" + 0 + "" + timer.get(2)); break;
					case 4: strTimer.replace(0,strTimer.length(), timer.get(0) + "" + timer.get(1) + ":" + timer.get(2) + timer.get(3)); break;
					default : break;
				}
	
				// System.out.println(timer);
				System.out.println("\nTimer Length: " + timer.size());
				System.out.println("String Timer: " + strTimer.toString());
				labelTimer.setText(strTimer.toString());
				
				if (((Button) e.getSource()).getText() == "Start") {
					System.out.println("Start");
					timerAnim();
				}
				if (((Button) e.getSource()).getText() == "Cancel") {
					timer.clear();
					strTimer.replace(0, strTimer.length(), "00:00");
					System.out.println("Cancel");
				}
			});
						
		}		
	
		//ImageView
		Image image = new Image("https://s3.amazonaws.com/productuploader-uploads/staging/2/Image/9279355_1716966125_FMOS1746BS-HOV");
		ImageView imgView = new ImageView(image);
		imgView.setFitHeight(200);
		imgView.setFitWidth(300);
		
		int k = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				gPane.add(buttons[k], j, i);
				k++;
			}
		}

		VBox vBox = new VBox();
		vBox.getChildren().add(labelTimer);
		
		vBox.getChildren().add(gPane);
		vBox.setSpacing(50);
		
		GridPane gPane1 = new GridPane();
		gPane1.setGridLinesVisible(true);
		gPane1.add(imgView, 0, 1);
		gPane1.add(vBox, 1, 1);
		
		gPane1.setAlignment(Pos.CENTER);
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(gPane1);
		
		Scene scene = new Scene(bPane, 600, 400);
		stage.setTitle("Microwave");
		stage.setScene(scene);
		stage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//Add integers in the timer ArrayList
	public void addInt(int i) {
		if(timer.size() < 4) {
			timer.add(i);
		}
	}
	
	//Add string to strTimer StringBuilder
	public void addStr(String i) {
		if(strTimer.length() < 5) {
			strTimer.append(i);
		}
	}
		
	
	public void timerAnim() {
		
		//EX: If the min1 (n0:00) i greater than or equal to 6, then find the moduli of n/6 and replace minute 1 with n/6 and create hr1 as n%6
		//Same rule applies for sec1
		
		int hr2 = 0, min1 = 0, min2 = 0, sec1 = 0, sec2 = 0;
		int totalTime = 0;
		
		if(timer.size() > 3) {
			//First find the remainder, then multiply by 100
			hr2 = (timer.get(0) >= 6)? (timer.get(0) / 6) : 0;
			
			min1 = (timer.get(0) >= 6)? (timer.get(0) % 6) : timer.get(0);
			min2 = (timer.get(2) >= 6)? (timer.get(2) / 6) + timer.get(1) : timer.get(1);
			sec1 = (timer.get(2) >= 6)? (timer.get(2) % 6) : timer.get(2);
			sec2 = timer.get(3);
			
			totalTime = (hr2 * 10000) + (min1 * 1000) + (min2 * 100) + (sec1 * 10) + sec2;
			
		}else if(timer.size() > 2) {
			hr2 = (timer.get(0) >= 6)? (timer.get(0) / 6) : 0;
			
			min1 = (timer.get(0) >= 6)? timer.get(0) % 6 : timer.get(0);
			min2 = timer.get(1); //(timer.get(1) >= 6)? (timer.get(0) % 6) : timer.get(1);
			sec1 = 0; /**(timer.get(0) >= 6)? ((timer.get(1) >= 6)? (timer.get(1) % 6) : timer.get(1)) : 0;*/ //Ignore this terniary
			sec2 = timer.get(2);
			
			totalTime = (hr2 * 10000) + (min1 * 1000) + (min2 * 100) + (sec1 * 10) + sec2;
			
		}else if(timer.size() > 1) {
			min2 = (timer.get(0) >= 6)? (timer.get(0) / 6) : 0;
			sec1 = (timer.get(0) >= 6)? (timer.get(0) % 6) : timer.get(0);
			sec2 = timer.get(1);
			
			totalTime = (min2 * 100) + (sec1 * 10) + sec2;
			
		}else if(timer.size() > 0) {
			sec2 = timer.get(0);
			
			totalTime = sec2;
		}else {
			totalTime = 0;
		}
		
		System.out.println("\nTimerAnim Total time: " + totalTime);
		
//		for(int i = totalTime; i > 0; i--) {
//			System.out.println(i);
//			delay(2);
//		}
//		System.out.println("Timer Finished");
		
		if(hr2 != 0) {
			System.out.println("TimerAnim Format: " + hr2 + ":" + min1 + "" + min2 + ":" + sec1 + "" + sec2);
			labelTimer.setText(hr2 + ":" + min1 + "" + min2 + ":" + sec1 + "" + sec2);
		}else {
			System.out.println("TimerAnim Format: " + min1 + "" + min2 + ":" + sec1 + "" + sec2);
			labelTimer.setText(min1 + "" + min2 + ":" + sec1 + "" + sec2);
		}
		
	}

}
