package de.adornis.snookercalculator;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by fightcookie on 9/9/2014.
 */
class Calculator extends AsyncTask<Integer, Void, Integer> {

	TextView textview;

	Calculator (TextView newTextView) {
		textview = newTextView;
	}

	@Override
	protected Integer doInBackground(Integer... params) {
		int player = params[0];
		int ballValue = params[1];

		Table table1 = new Table();
		table1.resetTable();
		return table1.remainingPoints();
	}

	@Override
	protected void onPostExecute(Integer remainingPoints) {
		textview.setText(String.valueOf(remainingPoints));
	}
}
