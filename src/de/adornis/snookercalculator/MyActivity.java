package de.adornis.snookercalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void calcResultPlayer1 (View ballValueSubmitButtonView) {
		calcResult(1, ballValueSubmitButtonView);
	}

	public void calcResultPlayer2 (View ballValueSubmitButtonView) {
		calcResult(2, ballValueSubmitButtonView);
	}

	public void calcResult(int player, View ballValueSubmitButtonView) {
		Button ballValueSubmitButtonButton = (Button) ballValueSubmitButtonView;
		String ballValueString = (String) ballValueSubmitButtonButton.getText();
		int ballValueInt = 0; //0 was what idea made, use null? handle null different, in switch?
//		find column of grid view to determine player?
//		ViewGroup.LayoutParams ballValueSubmitButtonButtonLayoutParams = ballValueSubmitButtonButton.getLayoutParams();
		switch (ballValueString) {
			case "red":
				ballValueInt = 1;
				break;
			case "yellow":
				ballValueInt = 2;
				break;
			case "green":
				ballValueInt = 3;
				break;
			case "brown":
				ballValueInt = 4;
				break;
			case "blue":
				ballValueInt = 5;
				break;
			case "pink":
				ballValueInt = 6;
				break;
			case "black":
				ballValueInt = 7;
				break;
			default:
				break;
		}
		new Calculator().execute(player, ballValueInt);
	}


}
