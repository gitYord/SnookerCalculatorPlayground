package de.adornis.snookercalculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

	private Table table1;
	private Handler uiHandler;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		table1 = new Table();
		table1.resetTable();
		uiHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				Bundle bundle = msg.getData();
				int remainingPoints = bundle.getInt("remainingPoints");
				((TextView) findViewById(R.id.remainingPointsTextView)).setText(String.valueOf(remainingPoints));
			}
		};
	}

	public void calcResultPlayer1 (View ballValueSubmitButtonView) {
		calcResult(1, ballValueSubmitButtonView);
	}

	public void calcResultPlayer2 (View ballValueSubmitButtonView) {
		calcResult(2, ballValueSubmitButtonView);
	}

	private void calcResult(int player, View ballValueSubmitButtonView) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				Button ballValueSubmitButtonButton = (Button) ballValueSubmitButtonView;
				String ballValueString = (String) ballValueSubmitButtonButton.getText();
				int ballValueInt = 0; //0 was what idea made, use null? handle null different, in switch?
//				find column of grid view to determine player?
//				ViewGroup.LayoutParams ballValueSubmitButtonButtonLayoutParams = ballValueSubmitButtonButton.getLayoutParams();
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
				int remainingPoints = table1.remainingPoints();
				Bundle tableInfos = new Bundle(3);
				tableInfos.putInt("remainingPoints", remainingPoints);
				Message tableUpdate = uiHandler.obtainMessage();
				tableUpdate.setData(tableInfos);
				Log.e("working", "working hard now");
				for(int i = 0; i < 99999999; i++); // freezes ui
				Log.e("working", "working was hard...");
				uiHandler.sendMessage(tableUpdate);

//				new Calculator((TextView) findViewById(R.id.remainingPointsTextView)).execute(player, ballValueInt);
			}
		}).start();
//		TextView remainingPointsTextView = (TextView) findViewById(R.id.remainingPointsTextView);
//		remainingPointsTextView.setText(String.valueOf(table1.remainingPoints()));
	}

	@Override
	protected void onDestroy() {
//		finish();
		super.onDestroy();
	}
}
