package de.adornis.snookercalculator;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fightcookie on 9/9/2014.
 */
class Calculator extends AsyncTask<Integer, Void, Integer> {

	@Override
	protected Integer doInBackground(Integer... params) {
		int player = params[0];
		int ballValue = params[1];

		return (new Table()).remainingPoints();
	}

	void onPostExecute(int remainingPoints) {
		final View remainingPointsView = findViewById(R.id.remainingPointsTextView);
		TextView remainingPointsTextView = (TextView) remainingPointsView;
		remainingPointsTextView.setText(String.valueOf(remainingPoints));
	}
}
